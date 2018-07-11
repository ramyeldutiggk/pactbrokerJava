package com.metro.service.impl;

import org.springframework.stereotype.Component;

import com.metro.response.dto.User;
import com.metro.service.UserService;

/**
 * Service to mock the user details information required for the services.
 *
 */
@Component
public class UserServiceImpl implements UserService {

  /*
   * (non-Javadoc)
   * 
   * @see com.metro.service.UserService#getUserDetails()
   */
  public User getUserDetails() {
    User user = new User();
    user.setId(1);
    user.setName("John");
    return user;
  }

}
