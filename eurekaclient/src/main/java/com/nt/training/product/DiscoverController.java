package com.nt.training.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DiscoverController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/clients/{instanceId}")
    public Object getUrlByServiceId(@PathVariable(name = "instanceId") String id){
        List<ServiceInstance> list = discoveryClient.getInstances(id);
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri();
        }
        // Instantiate
        RestTemplate template = new RestTemplate();
        // Provide target (note the placeholder)
        String url =  "http://paymentservices/{0}";
        // Call the URL, provide the expected class, provide value for placeholder,
        Object obj = template.getForObject(url, Object.class, 123);
        return null;

    }
}
