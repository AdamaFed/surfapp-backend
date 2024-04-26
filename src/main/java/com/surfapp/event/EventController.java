package com.surfapp.event;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private final EventRepository eventRepository;


    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(
            path = "api/events",
            produces = "application/json; charset=utf-8"
    ) public Object[] getEvents(){
        System.out.println("Get Mapping: Events");
        return this.eventRepository.findAll().toArray();
    }

    @PostMapping(
            path = "api/events",
            consumes = "application/json; charset=utf-8"
    ) public void addEvent(@RequestBody Event object){

        Event newEvent = new Event(object.getName(),object.getDescription(),object.getDate());
        this.eventRepository.save(newEvent);
    }







}
