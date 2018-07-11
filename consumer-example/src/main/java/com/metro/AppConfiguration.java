package com.metro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Configuration
 *
 */
@SpringBootApplication
public class AppConfiguration {

  /**
   * main method to bootstrap the spring boot application.
   * 
   * @param args
   */
  public static void main(String args[]) {
    SpringApplication.run(AppConfiguration.class, args);
  }

}
