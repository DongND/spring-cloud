package com.nt.training.configclientbus;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "test")
@Configuration
public class ConfigurationReceiver {
    private String message;

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
