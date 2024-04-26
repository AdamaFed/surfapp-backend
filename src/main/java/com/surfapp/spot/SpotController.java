package com.surfapp.spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotController {
    private final SpotRepository spotRepositoy;


    @Autowired
    public SpotController(SpotRepository spotRepositoy) {
        this.spotRepositoy = spotRepositoy;
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(
            path = "api/test1",
            produces = "application/json; charset=utf-8"
    ) public Object[] getSpots(){
        System.out.println("Get Mapping: Spots");
        return this.spotRepositoy.findAll().toArray();
    }

    @PostMapping(
            path = "api/test1",
            consumes = "application/json; charset=utf-8"
    ) public void addSpot(@RequestBody Spot object){

        Spot newSpot = new Spot(object.getName(),object.getLongitude(),object.getLatitude(),object.getFacing());
        this.spotRepositoy.save(newSpot);
    }







}
