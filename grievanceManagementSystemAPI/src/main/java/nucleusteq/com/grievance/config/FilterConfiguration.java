package nucleusteq.com.grievance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nucleusteq.com.grievance.filter.AuthenticationFilter;
import nucleusteq.com.grievance.service.UserService;

@Configuration
public class FilterConfiguration {

  /**
   * Class variable.
   */
   @Autowired
   private UserService userService;

   /**
    *
    * @param userServiceParam
    */
   public FilterConfiguration(final UserService userServiceParam) {
       this.userService = userServiceParam;
   }

   /**
    *
    * @return FilterRegistrationBean.
    */
  @Bean
  public FilterRegistrationBean<AuthenticationFilter> registrationBean() {
    FilterRegistrationBean<AuthenticationFilter> regBean
        = new FilterRegistrationBean<AuthenticationFilter>();
    regBean.setFilter(new AuthenticationFilter(userService));
    regBean.addUrlPatterns("/department/admin/*");
    regBean.addUrlPatterns("/user/admin/*");
    return regBean;
  }
}
