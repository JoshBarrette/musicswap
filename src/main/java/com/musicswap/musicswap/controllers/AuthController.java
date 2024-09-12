package com.musicswap.musicswap.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

@RestController()
@RequestMapping("/auth")
public class AuthController {
    private final SpotifyApi spotifyApi;

    private AuthController() {
        URI redirectURI = SpotifyHttpManager.makeUri("https://www.barrette.dev");
        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId("")
                .setClientSecret("")
                .setRedirectUri(redirectURI)
                .build();
    }

    @GetMapping("/spotify")
    @ResponseBody()
    public String spotifyLogin() {
        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
                .scope("user-read-private, user-read-email, user-top-read")
                .show_dialog(true)
                .build();
        final URI uri = authorizationCodeUriRequest.execute();
        return uri.toString();
    }
}
