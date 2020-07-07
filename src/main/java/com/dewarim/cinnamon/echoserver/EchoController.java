package com.dewarim.cinnamon.echoserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@RestController
public class EchoController {

    Logger logger = LoggerFactory.getLogger(EchoController.class);

    @RequestMapping(value = "/echo", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.ALL_VALUE)
    public String echo(HttpServletRequest request, HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            logger.info("content-type:" +objectMapper.writeValueAsString(request.getHeader(CONTENT_TYPE)));
            return objectMapper.writeValueAsString(request.getParameterMap());
        } catch (JsonProcessingException e) {
            logger.warn("Failed to write parameterMap:\n",e);
            throw new IllegalStateException(e);
        }
    }
}

