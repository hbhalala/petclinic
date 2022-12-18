package com.project.petclinic.api.service;

import com.project.petclinic.api.entity.Pet;
import com.project.petclinic.api.repository.PetCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetCreator petCreator;

    public List<Pet> getMockPets() {
        long start=System.currentTimeMillis();
        List<Pet> pets = petCreator.getPets();
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end-start));
        return pets;
    }

    public Flux<Pet> getMockPetsStream() {
        long start=System.currentTimeMillis();
        Flux<Pet> pets = petCreator.getPetsStream();
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end-start));
        return pets;
    }
}
