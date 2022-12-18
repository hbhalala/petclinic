package com.project.petclinic.api.repository;

import com.project.petclinic.api.entity.Pet;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PetCreator {
    private static void sleepExecition(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Pet> getPets() {
        return IntStream.rangeClosed(1,10)
                .peek(PetCreator::sleepExecition)
                .peek(i->System.out.println("Processing: "+i))
                .mapToObj(i->new Pet(i, "firstname"+i, "lastname"+i))
                .collect(Collectors.toList());
    }

    public Flux<Pet> getPetsStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("Processing in stream: "+i))
                .map(i->new Pet(i, "firstname"+i, "lastname"+i));
    }

    public Flux<Pet> getPetsStreamNoDelay() {
        return Flux.range(1,50)
                .doOnNext(i->System.out.println("Processing in stream: "+i))
                .map(i->new Pet(i, "firstname"+i, "lastname"+i));
    }
}
