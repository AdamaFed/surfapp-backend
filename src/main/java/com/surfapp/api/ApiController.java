package com.surfapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ApiController {
    private final LocationServiceImpl locationService;
    private final MeteomaticsServiceImpl meteomaticsService;
    @Autowired
    public ApiController(LocationServiceImpl locationService, MeteomaticsServiceImpl meteomaticsService) {
        this.locationService = locationService;
        this.meteomaticsService = meteomaticsService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(
            path = "api/v1/location",
            produces = "application/json; charset=utf-8"
    ) public String location(@RequestParam String location){
        System.out.println("Get Mapping: location");
        return this.locationService.getLongLat(location);
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(
            path = "api/v1/meteomatics",
            produces = "application/json; charset=utf-8"
    ) public String forecast(@RequestParam String latitude,
                             @RequestParam String longitude,
                             @RequestParam String startDate,
                             @RequestParam String endDate){
        System.out.println("Get Mapping: meteomatics");
        return this.meteomaticsService.getForecast(latitude, longitude, startDate, endDate);
    }

}
