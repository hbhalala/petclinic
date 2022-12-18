package com.project.petclinic.api.handler;

import com.project.petclinic.api.entity.Pet;
import com.project.petclinic.api.repository.PetCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PetStreamHandler {
    @Autowired
    private PetCreator petCreator;
    public Mono<ServerResponse> getPetsSteam(ServerRequest serverRequest00) {
        Flux<Pet> petsSteam = petCreator.getPetsStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(petsSteam, Pet.class);
    }

}
