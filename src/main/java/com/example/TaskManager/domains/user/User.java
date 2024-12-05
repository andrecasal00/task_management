package com.example.TaskManager.domains.user;

import com.example.TaskManager.domains.role.Role;
import com.example.TaskManager.domains.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "role_uuid")
    private Role role;
}
