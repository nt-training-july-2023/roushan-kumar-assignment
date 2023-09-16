//package nucleusteq.com.grievance.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
////@EnableWebMvc
//public class CorsConfig //implements WebMvcConfigurer
//{
//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//      CorsConfiguration config = new CorsConfiguration();
//      config.addAllowedOrigin("http://localhost:3000"); // Add your React app's origin
//      config.addAllowedMethod("*"); // Allow all HTTP methods
//      config.addAllowedHeader("*"); // Allow all headers
//
//      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", config);
//
//      return source;
//  }
//  
////  @Bean
////  public CorsFilter corsFilter() {
////      CorsConfiguration config = new CorsConfiguration();
////      config.addAllowedOrigin("http://localhost:3000");
////      config.addAllowedHeader("*");
////      config.addAllowedMethod("*");
////      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////      source.registerCorsConfiguration("/**", config);
////      return new CorsFilter(source);
////  }
//  
////  @Override
////  public void addCorsMappings(CorsRegistry registry) {
////      
////    
////      registry.addMapping("/**")
////              .allowedOrigins("http://localhost:3000")
////              .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
////              .allowedHeaders("Authorization")
////              
////              .exposedHeaders("Authorization")
////              .allowCredentials(true);
////  }
//
//}
