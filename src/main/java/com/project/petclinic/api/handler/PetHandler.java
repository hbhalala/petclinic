package com.project.petclinic.api.handler;

import com.project.petclinic.api.entity.Pet;
import com.project.petclinic.api.repository.PetCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PetHandler {
    @Autowired
    private PetCreator petCreator;

    public Mono<ServerResponse> loadPets(ServerRequest request) {
        Flux<Pet> petsStreamNoDelay = petCreator.getPetsStreamNoDelay();
        return ServerResponse.ok()
                .body(petsStreamNoDelay, Pet.class);
    }
}
