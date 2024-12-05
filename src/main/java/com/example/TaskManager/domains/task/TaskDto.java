package com.example.TaskManager.domains.task;

import java.time.LocalDateTime;
import java.util.Date;

public record TaskDto(
        String title,
        String description,
        Status status,
        Date dateTime
) {
}
