package com.example.TaskManager.domains.user;

public record UserDto(
        String username,
        String email,
        String password
) {
}
