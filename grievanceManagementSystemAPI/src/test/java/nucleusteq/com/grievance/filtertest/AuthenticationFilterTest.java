package nucleusteq.com.grievance.filtertest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.filter.AuthenticationFilter;
import nucleusteq.com.grievance.service.UserService;

public class AuthenticationFilterTest {

  @Mock
  private HttpServletRequest request;
  @Mock
  private HttpServletResponse response;
  @Mock
  private FilterChain chain;
  @Mock
  private UserService userService;
  
  private AuthenticationFilter filter;
  @BeforeEach
  void setUp() {
      MockitoAnnotations.openMocks(this);
      filter = new AuthenticationFilter(userService);
  }
  @Test
  void testDoFilterAuthorized() throws Exception {
    UserDto user = new UserDto();
    user.setUsername("root_user");
    user.setPassword("12345678");
      when(request.getMethod()).thenReturn("GET");
      when(request.getHeader("username")).thenReturn("root_user"); 
      when(request.getHeader("password")).thenReturn("cm9vdEAxMjM="); 
      when(userService.authenticateIsAdmin(user)).thenReturn(true);

      filter.doFilter(request, response, chain);
 
      //verify(chain).doFilter(request, response);
  }
  @Test
  void testDoFilterUnauthorized() throws Exception {
      UserDto user = new UserDto();
      user.setUsername("invalidUsername");
      user.setPassword("invalidPassword");
      when(request.getMethod()).thenReturn("GET");
      when(request.getHeader("username")).thenReturn("invalidUsername");
      when(request.getHeader("password")).thenReturn("invalidPassword");
      when(userService.authenticateIsAdmin(user)).thenReturn(false);
      filter.doFilter(request, response, chain);
      verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
  }

  @Test
  void testDoFilterhttpServletRequestOption() throws Exception {
      UserDto user = new UserDto();
      user.setUsername("invalidUsername");
      user.setPassword("invalidPassword");
      when(request.getMethod()).thenReturn("GET");
      when(request.getHeader("username")).thenReturn("invalidUsername");
      when(request.getHeader("password")).thenReturn("invalidPassword");
      when(userService.authenticateIsAdmin(user)).thenReturn(false);
      when(request.getMethod()).thenReturn("OPTIONS");
      filter.doFilter(request, response, chain);
      //verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
  }

}
