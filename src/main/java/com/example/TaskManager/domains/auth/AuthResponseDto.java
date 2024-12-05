package com.example.TaskManager.domains.auth;

public record AuthResponseDto(
        String userUuid,
        String token
) {
}
