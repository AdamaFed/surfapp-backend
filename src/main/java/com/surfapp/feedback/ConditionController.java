package com.surfapp.feedback;

import com.surfapp.spot.Spot;
import com.surfapp.spot.SpotRepository;
import com.surfapp.user.User;
import com.surfapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConditionController {

    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final SpotRepository spotRepository;

    @Autowired
    public ConditionController(ConditionRepository conditionRepository, UserRepository userRepository, SpotRepository spotRepository) {
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.spotRepository = spotRepository;
    }







    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(
            path = "api/condition",
            produces = "application/json; charset=utf-8"
    ) public List<ConditionDto> getConditions(){
        System.out.println("Get Mapping: Conditions");
        return this.conditionRepository.findAll().stream().map(e -> new ConditionDto(e.getSpot().getId(),e.getWindDirection(),e.getWindSpeed(),e.getRating())).toList();
    }

    @PostMapping(
            path = "api/condition",
            consumes = "application/json; charset=utf-8"
    ) public void addCondition(@RequestBody ConditionDto conditionDto){
        System.out.println("Post Mapping: Conditions");
        Spot spot = this.spotRepository.findById(conditionDto.getSpotId()).orElseThrow();
        Condition condition = new Condition(conditionDto.getWindDirection(),conditionDto.getWindSpeed(),conditionDto.getRating(),spot);
        this.conditionRepository.save(condition);
    }

}
