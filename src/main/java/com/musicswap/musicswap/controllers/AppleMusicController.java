package com.musicswap.musicswap.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController()
@RequestMapping("/apple")
public class AppleMusicController {
    private final RestClient restClient;

    public AppleMusicController() {
        this.restClient = RestClient.create();
    }

    @GetMapping()
    public String testRequest() {
        return restClient.get().uri("http://localhost:8080/health").retrieve().toEntity(String.class).getBody();
    }
}
