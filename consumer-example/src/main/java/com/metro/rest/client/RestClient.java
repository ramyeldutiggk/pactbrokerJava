package com.metro.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.metro.rest.dto.User;

/**
 * REST Client provides methods to interact with REST APIs.
 */
public class RestClient {
  private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);
  private RestTemplate restTemplate;
  private String restUrl;

  public RestClient(String restUrl) {
    this.restUrl = restUrl;
    restTemplate = new RestTemplate();
  }

  /**
   * Invokes REST API to fetch the user details.
   * 
   * @return
   */
  public User getUser() {
    User user = null;
    try {
      user = restTemplate.getForObject(restUrl + "/user", User.class);
    } catch (Exception e) {
      LOG.error("Error while fetching the user details", e);
    }
    return user;
  }
}
