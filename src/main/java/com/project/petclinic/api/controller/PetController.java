package com.project.petclinic.api.controller;

import com.project.petclinic.api.entity.Pet;
import com.project.petclinic.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;
    @GetMapping("/")
    public ResponseEntity<List<Pet>> getMockPets() {
        return new ResponseEntity<>(petService.getMockPets(), HttpStatus.OK);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<Pet>> getMockPetsStream() {
        return new ResponseEntity<>(petService.getMockPetsStream(), HttpStatus.OK);
    }
}
