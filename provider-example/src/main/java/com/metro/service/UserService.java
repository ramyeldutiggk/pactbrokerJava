package com.metro.service;

import com.metro.response.dto.User;

public interface UserService {

  /**
   * prepares mock data for the user details and returns the {@link User} object.
   */
  User getUserDetails();
}
