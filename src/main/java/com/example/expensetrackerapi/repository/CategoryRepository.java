package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.exceptions.EtBadRequest;
import com.example.expensetrackerapi.exceptions.EtResourceNotFoundException;
import com.example.expensetrackerapi.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;
    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
    Integer create(Integer userId, String title, String description) throws EtBadRequest;
    void update(Integer userId, Integer categoryId, Category category) throws EtBadRequest;
    void removeById(Integer userId, Integer categoryId);
}
