package com.surfapp.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import java.net.URI;


@Service
public class MeteomaticsServiceImpl {
    private final RestTemplate restTemplate;
    @Value("${meteomatics.base.url}")
    private String baseUrl;

    @Value("${meteomatics.username}")
    private String username;

    @Value("${meteomatics.password}")
    private String password;



    public MeteomaticsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getForecast(String latitude, String longitude, String startDate, String endDate) {

        String url = baseUrl + "/" +startDate + "--" + endDate + ":PT1H/first_low_tide:sql,first_high_tide:sql,second_low_tide:sql,second_high_tide:sql,tidal_amplitude:cm/" + latitude + "," + longitude + "/json?model=mix";
        HttpHeaders headers = new HttpHeaders();

        headers.setBasicAuth(username, password);

        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        return responseEntity.getBody();
    }

}
