package com.project.petclinic.api.router;

import com.project.petclinic.api.handler.PetHandler;
import com.project.petclinic.api.handler.PetStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class RouterConfig {

    @Autowired
    private PetHandler petHandler;
    @Autowired
    private PetStreamHandler petStreamHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router/pets", petHandler::loadPets)
                .GET("/router/pets/stream", petStreamHandler::getPetsSteam)
                .build();
    }
}
