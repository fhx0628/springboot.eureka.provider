package com.fhx.springboot.eureka.provider.domain.serviceInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceInstanceController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-instances")
    public List<ServiceInstance> getConsumerServiceInstances(@Value("${eureka.client.provider.name}") String applicationName) {
        return discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/port")
    public String getPort(@Value("${server.port}") String port) {
        return port;
    }
}
