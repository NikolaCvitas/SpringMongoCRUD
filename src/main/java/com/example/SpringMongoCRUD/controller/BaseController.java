package com.example.SpringMongoCRUD.controller;

import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
public class BaseController {

    private final Log log = LogFactory.getLog(this.getClass());



    protected void init(){

        log.info("Init BaseController");
    }

    public void print(String message){

        System.out.println(message);
    }
}
