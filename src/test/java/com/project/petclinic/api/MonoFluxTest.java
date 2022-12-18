package com.project.petclinic.api;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono() {
        Mono<String> monoString = Mono.just("monostring").log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void testMonoError() {
        Mono<?> monoString = Mono.just("monostring")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::println, e->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
                .concatWithValues("cloud")
                .log();
        stringFlux.subscribe(System.out::println);
    }
}
