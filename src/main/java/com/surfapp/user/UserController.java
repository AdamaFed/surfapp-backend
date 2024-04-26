package com.surfapp.user;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "/api/v1/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID register(@RequestBody UserCreationDto dto) {

            User user = userRepository.findByUsername(dto.getUsername());
            if (user == null) {
                User createdUser = userRepository.save(
                        new User(
                                UUID.randomUUID(),
                                dto.getUsername(),
                                bCryptPasswordEncoder.encode(dto.getPassword()),
                                Role.USER
                        )
                );
                return createdUser.getId();
            }
            return null;


    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/all")
    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                    .map(user -> new UserDto(user.getId(),user.getUsername(), user.getRole()))
                        .toList();
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/me")
    public UserDto getMyDetails(Principal principal) {
        User currentUser = this.userRepository.findByUsername(principal.getName());

        return new UserDto(currentUser.getId(),currentUser.getUsername(),currentUser.getRole());
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable UUID id) {
        System.out.println("Deletemapping: User");
        userRepository.deleteById(id);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable UUID id) {
        System.out.println("Putmapping: User");
        User user =  this.userRepository.findById(id).orElseThrow();
        if (user.getRole() == Role.ADMIN) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.ADMIN);
        }
        userRepository.save(user);
    }




}
