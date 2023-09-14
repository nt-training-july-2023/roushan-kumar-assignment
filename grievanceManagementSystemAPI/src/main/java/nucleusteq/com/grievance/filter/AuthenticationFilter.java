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

@Component
public class AuthenticationFilter implements Filter {
    
    @Autowired
    private UserService authenticationService;
    
    public AuthenticationFilter(UserService authenticationService) {
      this.authenticationService = authenticationService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //System.out.println(request.toString());
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String username = httpServletRequest.getHeader("username");
        String password = httpServletRequest.getHeader("password");
        if(username==null || password==null) {
        	throw new UserNotFoundException("Header not found !!");
        }
        System.out.println("In filter "+username +" "+ password);
        UserDto user = new UserDto();
        user.setUsername(username);
        user.setPassword(password);
        
        UserDto userWithPasswordEncrypted = new UserDto();
        userWithPasswordEncrypted.setUsername(username);

        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println("Decode pass " + decodedString);
        userWithPasswordEncrypted.setPassword(decodedString);

        if (authenticationService.authenticateIsAdmin(user)) {
            chain.doFilter(request, response);
        } else if (authenticationService.authenticateIsAdmin(userWithPasswordEncrypted)) {
        	chain.doFilter(request, response);
        }  else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials Form filter");
        }
    }
}