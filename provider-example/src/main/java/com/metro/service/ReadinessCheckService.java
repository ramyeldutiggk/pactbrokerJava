package com.metro.service;

public interface ReadinessCheckService {

  /**
   * Returns the readiness of the application.
   * 
   * @return boolean value
   */
  boolean isReady();

  /**
   * This method is used to set the readiness of the application. Currently not used in this
   * implementation
   * 
   * @param ready
   */
  void setReady(boolean ready);
}
