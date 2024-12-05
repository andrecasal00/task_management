package com.example.TaskManager.domains.role;

import com.example.TaskManager.domains.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tbl_user_role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String role;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
