package com.djh.demo.JerseyConfig;

import com.djh.demo.Controller.TestController;
import com.djh.demo.Controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
//        register(UserController.class);
        register(TestController.class);
    }
}
