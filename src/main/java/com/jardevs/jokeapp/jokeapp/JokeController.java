package com.jardevs.jokeapp.jokeapp;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    @GetMapping("/makeanyjoke")
    public String makeAnyJoke() {
        RestTemplate restTemplate = new RestTemplate();
        Joke joke = restTemplate.getForObject("https://v2.jokeapi.dev/joke/Any", Joke.class);
        return displayJoke(joke);
    }

    public static String displayJoke(Joke joke) {
        return joke.setup + joke.delivery;
    }
}
