package com.example.TaskManager.domains.task;

import com.example.TaskManager.domains.category.Category;
import com.example.TaskManager.domains.user.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @NotBlank
    private String title;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "duedate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "category_uuid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
