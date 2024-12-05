package com.example.TaskManager.controllers;

import com.example.TaskManager.domains.category.Category;
import com.example.TaskManager.domains.category.CategoryDto;
import com.example.TaskManager.domains.user.User;
import com.example.TaskManager.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(
            @AuthenticationPrincipal User user,
            @RequestBody() CategoryDto dto
    ) {
        Category category = this.categoryService.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategory(
            @AuthenticationPrincipal User user,
            @PathVariable()UUID categoryUuid
            ) {
        this.categoryService.deleteCategory(categoryUuid);
        return ResponseEntity.ok("Category deleted with success");
    }

    @GetMapping
    public List<Category> getAllCategories(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(this.categoryService.getAllCategories()).getBody();
    }
}
