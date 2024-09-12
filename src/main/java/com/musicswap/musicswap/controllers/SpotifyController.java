package com.musicswap.musicswap.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController()
@RequestMapping("/spotify")
public class SpotifyController {
    private final RestClient restClient;

    public SpotifyController() {
        this.restClient = RestClient.create();
    }

    @GetMapping()
    public String testRequest() {
        return restClient.get().uri("http://localhost:8080/health").retrieve().toEntity(String.class).getBody();
    }
}
