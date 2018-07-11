package com.metro.service;

public interface LivenessCheckService {
  /**
   * Returns the liveness of the application.
   * 
   * @return boolean value
   */
  boolean isLive();

  /**
   * This method is used to set the liveness of the application. Currently not used in this
   * implementation
   * 
   * @param live
   */
  void setLive(boolean live);
}
