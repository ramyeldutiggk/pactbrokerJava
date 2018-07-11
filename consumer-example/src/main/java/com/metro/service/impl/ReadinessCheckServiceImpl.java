package com.metro.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.metro.service.ReadinessCheckService;


/**
 * Implementation to represent the readiness of the application.
 *
 */
@Service
public class ReadinessCheckServiceImpl implements ReadinessCheckService {
  private static final Logger LOG = LoggerFactory.getLogger(ReadinessCheckServiceImpl.class);

  private boolean ready = true;

  /*
   * (non-Javadoc)
   * 
   * @see com.metro.service.ReadinessCheckService#isReady()
   */
  public boolean isReady() {
    return ready;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.metro.service.ReadinessCheckService#setReady(boolean)
   */
  public void setReady(boolean ready) {
    LOG.info("Set ready to {}", ready);
    this.ready = ready;
  }

}
