package nucleusteq.com.grievance.filtertest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.filter.AuthenticationFilter;
import nucleusteq.com.grievance.service.UserService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class AuthenticationFilterTest {

	private MockMvc mockMvc;

  @InjectMocks
  private AuthenticationFilter authenticationFilter;

  @Mock
  private UserService userService;

  @Before
  public void setUp() {
      MockitoAnnotations.openMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup(authenticationFilter).build();
  }

  @Test
  public void testValidAuthentication() throws Exception {
      HttpServletRequest request = mock(HttpServletRequest.class);
      HttpServletResponse response = mock(HttpServletResponse.class);
      FilterChain filterChain = mock(FilterChain.class);
    
      UserDto user = new UserDto();
      user.setUsername("validUsername");
      user.setPassword("validPassword");
      
      // Set up the request with valid credentials
      String validUsername = "validUsername";
      String validPassword = "validPassword";

      // Encode the password to Base64
      String encodedPassword = Base64.getEncoder().encodeToString(validPassword.getBytes(StandardCharsets.UTF_8));
      
      // Set up the request with valid credentials
      when(request.getHeader("username")).thenReturn("validUsername");
      when(request.getHeader("password")).thenReturn(encodedPassword);

      // Mock the authentication service to return true for valid credentials
      when(userService.authenticateIsAdmin(any(UserDto.class))).thenReturn(true);

      // Call the doFilter method
      authenticationFilter.doFilter(request, response, filterChain);

      // Verify that the filter chain was invoked
      verify(filterChain, times(1)).doFilter(request, response);
  }

  @Test
  public void testInvalidAuthentication() throws Exception {
      HttpServletRequest request = mock(HttpServletRequest.class);
      HttpServletResponse response = mock(HttpServletResponse.class);
      FilterChain filterChain = mock(FilterChain.class);
      ServletRequest srequest = mock(ServletRequest.class);
      ServletResponse sresponse = mock(ServletResponse.class);

      UserDto user = new UserDto();
      user.setUsername("invalidUsername");
      user.setPassword("invalidPassword");
      // Set up the request with invalid credentials
      when(request.getHeader("username")).thenReturn("invalidUsername");
      when(request.getHeader("password")).thenReturn("invalidPassword");

      // Mock the authentication service to return false for invalid credentials
      when(userService.authenticateIsAdmin(any(UserDto.class))).thenReturn(false);

      // Call the doFilter method
      authenticationFilter.doFilter(request, response, filterChain);

      // Verify that an unauthorized status code is set in the response
      verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials Form filter");

      // Verify that the filter chain was not invoked
      verify(filterChain, never()).doFilter(srequest, sresponse);
  }
}
