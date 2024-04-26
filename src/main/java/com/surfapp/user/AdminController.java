package com.surfapp.user;

import com.surfapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class AdminController {

    private final UserRepository userRepository;

    @Autowired
    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @PutMapping("/update/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public UUID update(@PathVariable UUID id) {
//
//        User updateUser = userRepository.getUserById(id);
//
//        return updateUser.getId();
//    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/blub")
    public String blub(Principal principal) {
        userRepository.findByUsername(principal.getName());
        return "Wow! Hallo '" + principal.getName() + "' du bist immer willkommen";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/blib")
    public String blib(Principal principal) {

        return "Wow! Hallo '" + principal.getName() + "' nur ADMINS dürfen das sehen";
    }


}
