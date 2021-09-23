package com.nt.training.configclientbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private ConfigurationReceiver configurationReceiver;
    @GetMapping(value = "/helloworld")
    public String retrieveConfig(){
        return configurationReceiver.getMessage();
    }
}
