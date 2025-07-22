package io.javabrains.eureka_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentResource {

    @Autowired
    private Environment environment;

    @GetMapping("/env-details")
    public String getDetails(){
        return environment.toString();
    }
}
