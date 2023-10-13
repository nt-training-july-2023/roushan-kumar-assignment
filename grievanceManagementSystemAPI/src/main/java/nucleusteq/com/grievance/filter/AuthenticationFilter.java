package nucleusteq.com.grievance.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.exception.UserNotFoundException;
import nucleusteq.com.grievance.service.UserService;

/**
 * Authentication filter class.
 * For save department.
 * Only admin can add department.
 *
 * @author roushan Kumar
 */
@Component
public class AuthenticationFilter implements Filter {

  /**
   * userservice variable.
   */
  @Autowired
  private UserService authenticationService;

  /**
   * Constructor to initialize a UserService object.
   *
   * @param authenticationServiceParam
   */
  public AuthenticationFilter(
      final UserService authenticationServiceParam) {
    this.authenticationService = authenticationServiceParam;
  }

  /**
   * doFilet.
   */
  @Override
  public void doFilter(
      final ServletRequest request,
      final ServletResponse response,
      final FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    String username = httpServletRequest.getHeader("username");
    String password = httpServletRequest.getHeader("password");

    if (httpServletRequest.getMethod().equals("OPTIONS")) {
      httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
      httpServletResponse.setHeader("Access-Control-Allow-Methods",
          "GET, POST, PUT, DELETE");
      httpServletResponse.setHeader("Access-Control-Allow-Headers",
          "Authorization, Content-Type, username, password");
      httpServletResponse.setContentType("application/json");
      httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else {
    if (username == null || password == null) {
      throw new UserNotFoundException("Header not found !!");
    }
    UserDto user = new UserDto();
    user.setUsername(username);
    user.setPassword(password);

    UserDto userWithPasswordEncrypted = new UserDto();
    userWithPasswordEncrypted.setUsername(username);

    byte[] decodedBytes = Base64.getDecoder().decode(password);
    String decodedString = new String(decodedBytes,
        StandardCharsets.UTF_8);
    userWithPasswordEncrypted.setPassword(decodedString);

    if (authenticationService.authenticateIsAdmin(user)) {
      chain.doFilter(request, response);
    } else if (authenticationService.
        authenticateIsAdmin(userWithPasswordEncrypted)) {
      chain.doFilter(request, response);
    } else {
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
          "Invalid credentials");
    }
   }
  }
}
