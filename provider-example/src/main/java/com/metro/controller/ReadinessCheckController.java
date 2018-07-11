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

import com.metro.service.impl.ReadinessCheckServiceImpl;

/**
 * Controller for readiness REST API which is used by Kubernetes to check the readiness of the
 * application.
 *
 */
@RestController
public class ReadinessCheckController {
  private static final Logger LOG = LoggerFactory.getLogger(ReadinessCheckController.class);

  @Autowired
  private ReadinessCheckServiceImpl readinessCheckService;

  /**
   * Minimal implementation: Invokes the service to check the readiness, now it is always ready and
   * returns {@link ResponseEntity} with the status {@link HttpStatus.NO_CONTENT}
   * 
   * @param request
   * @param response
   * @return ResponseEntity
   */
  @RequestMapping(value = {"/.well-known/ready"}, method = {GET, HEAD})
  public ResponseEntity<String> live(HttpServletRequest request, HttpServletResponse response) {

    ResponseEntity<String> responseEntity = null;
    boolean ready = readinessCheckService.isReady();

    if (ready) {
      responseEntity = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    } else {
      responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    LOG.info("readiness check returns {}", ready);

    return responseEntity;
  }
}
