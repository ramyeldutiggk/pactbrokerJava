package com.metro.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.metro.service.LivenessCheckService;

/**
 * Implementation to represent the liveness status of the application.
 *
 */
@Service
public class LivenessCheckServiceImpl implements LivenessCheckService {
  private static final Logger LOG = LoggerFactory.getLogger(LivenessCheckServiceImpl.class);

  private boolean live = true;

  /*
   * (non-Javadoc)
   * 
   * @see com.metro.service.LivenessCheckService#isLive()
   */
  public boolean isLive() {
    return live;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.metro.service.LivenessCheckService#setLive(boolean)
   */
  public void setLive(boolean live) {
    LOG.info("Set live to {}", live);
    this.live = live;
  }
}
