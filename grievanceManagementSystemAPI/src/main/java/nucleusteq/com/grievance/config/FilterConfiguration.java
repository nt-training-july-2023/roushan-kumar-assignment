package nucleusteq.com.grievance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nucleusteq.com.grievance.filter.AuthenticationFilter;
import nucleusteq.com.grievance.service.UserService;

@Configuration
public class FilterConfiguration {

	 @Autowired
	 private UserService userService;
   public FilterConfiguration(UserService userService) {
       this.userService = userService;
   }
  @Bean
  public FilterRegistrationBean<AuthenticationFilter> registrationBean() {
  	FilterRegistrationBean<AuthenticationFilter> regBean 
  			= new FilterRegistrationBean<AuthenticationFilter>();
  	regBean.setFilter(new AuthenticationFilter(userService));
  	regBean.addUrlPatterns("/department/save/*");
  	System.out.println("in config filter.");
  	return regBean;
  }
}
