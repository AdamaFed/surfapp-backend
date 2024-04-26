package com.surfapp.user;

import java.util.UUID;

public class UserDto {
    UUID id;
    String username;
    Role role;

    public UserDto(UUID id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public UUID getId() {
        return id;
    }
}
