package nucleusteq.com.grievance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GrievanceManagementSystemApplication.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */
@SpringBootApplication
public class GrievanceManagementSystemApplication {

  protected GrievanceManagementSystemApplication() {
  }

  /**
   * main.
   *
   * @param args args
   */
  public static void main(final String[] args) {
    SpringApplication.run(GrievanceManagementSystemApplication.class, args);
  }
}
