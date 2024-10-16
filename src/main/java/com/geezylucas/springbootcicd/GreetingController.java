package com.geezylucas.springbootcicd;

import com.google.cloud.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final UserRepository userRepository;

    @GetMapping("/greetings")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World!");
    }

    @GetMapping("/user")
    public Flux<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public Mono<UserEntity> createUser(@RequestBody UserDTO userDTO) {
        return Mono.just(userDTO)
                .map(user -> UserEntity.builder()
                        .username(user.username())
                        .firstName(user.firstName())
                        .lastName(user.lastName())
                        .age(user.age())
                        .email(user.email())
                        .createdAt(Timestamp.now())
                        .build())
                .flatMap(userRepository::save);

    }
}
