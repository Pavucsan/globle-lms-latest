package com.pavucs.globelibraryservice.config;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MicroserviceCall {
    @Autowired
    @Lazy
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${base.url}")
    String baseUrl;

    public static final String GLOBLE_SERVICE = "globleService";

    private int attempt = 1;

    @CircuitBreaker(name = GLOBLE_SERVICE, fallbackMethod = "getAlter")
//    @Retry(name = USER_SERVICE,fallbackMethod = "getAlter")
    public ResponseEntity<Object> callService(String endpoint) {
        logger.info(baseUrl);
        System.out.println("retry method called " + attempt++ + " times " + " at " + new Date());
        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + endpoint, Object.class);
        return response;
    }

    public ResponseEntity<Object> getAlter() {
        Map<String, Object> map = new HashMap<>();
        map.put("MESSAGE", "SERVICE_NOT_CONNECTED");
        map.put("STATUS_CODE", 500);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


}
