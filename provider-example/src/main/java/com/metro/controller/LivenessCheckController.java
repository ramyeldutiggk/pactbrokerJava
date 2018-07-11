package com.metro.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metro.service.LivenessCheckService;

/**
 * Controller for liveness REST API which is used by Kubernetes to check the liveness of the
 * application.
 *
 */
@RestController
public class LivenessCheckController {
  private static final Logger LOG = LoggerFactory.getLogger(LivenessCheckController.class);

  @Autowired
  private LivenessCheckService livenessCheckService;

  /**
   * Minimal implementation: Invokes the service to check the liveness, now it is always live and
   * returns {@link ResponseEntity} with the status {@link HttpStatus.NO_CONTENT}
   * 
   * @param request
   * @param response
   * @return ResponseEntity
   */
  @RequestMapping(value = {"/.well-known/live"}, method = {GET, HEAD})
  public ResponseEntity<String> live(HttpServletRequest request, HttpServletResponse response) {

    ResponseEntity<String> responseEntity = null;
    boolean live = livenessCheckService.isLive();

    if (live) {
      responseEntity = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    } else {
      responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    LOG.info("liveness check returns {}", live);

    return responseEntity;
  }
}
