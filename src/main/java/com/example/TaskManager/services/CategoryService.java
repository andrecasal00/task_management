package com.example.TaskManager.services;

import com.example.TaskManager.domains.category.Category;
import com.example.TaskManager.domains.category.CategoryDto;
import com.example.TaskManager.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.name());
        this.categoryRepository.save(category);
        return category;
    }

    public void deleteCategory(UUID uuid) {
        this.categoryRepository.deleteById(uuid);
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }
}
