package com.surfapp.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationServiceImpl {
    private final RestTemplate restTemplate;
    @Value("${locationApi.base.url}")
    private String baseUrl;

    @Value("${locationApi.key}")
    private String key;



    public LocationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getLongLat(String location) {
        String url = baseUrl + location +"&limit=1&appid=" + key;
        return restTemplate.getForObject(url, String.class);
    }

}
