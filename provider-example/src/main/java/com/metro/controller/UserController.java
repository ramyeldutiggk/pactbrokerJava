package com.metro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metro.response.dto.User;
import com.metro.service.UserService;

/**
 * Controller which provides REST APIs for user resources.
 *
 */
@RestController
public class UserController {
  private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  /**
   * Returns {@link User} information by invoking {@link UserService}
   * 
   * @return
   */
  @RequestMapping("/user")
  public User userDetails() {
    LOG.info("invoking user service to get user details");
    return userService.getUserDetails();
  }
}
