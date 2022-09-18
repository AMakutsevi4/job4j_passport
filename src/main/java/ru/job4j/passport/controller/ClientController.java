package ru.job4j.passport.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.passport.model.Passport;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Value("${api.url}")
    private String urlApi;

    private final RestTemplate rest;

    public ClientController(RestTemplate rest) {
        this.rest = rest;
    }

    @PostMapping("/save")
    public void save(@RequestBody Passport passport) {
        String url = urlApi + "save";
        rest.postForObject(url, passport, Passport.class);
    }
    @GetMapping("/unavaliabe")
    public List<Passport> findAllByExpiredPeriod() {
        String url = urlApi + "unavaliabe";
        return rest.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }).getBody();
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findAllByReplaceInThreeMonths() {
        String url = urlApi + "find-replaceable";
        return rest.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }).getBody();
    }
}
