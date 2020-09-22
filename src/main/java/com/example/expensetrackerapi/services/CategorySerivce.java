package com.example.expensetrackerapi.services;

import com.example.expensetrackerapi.exceptions.EtBadRequest;
import com.example.expensetrackerapi.exceptions.EtResourceNotFoundException;
import com.example.expensetrackerapi.model.Category;

import java.util.List;

public interface CategorySerivce {
    List<Category> fetchAllCategories(Integer userId);
    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
    Category addCategory(Integer userId, String title, String description) throws EtBadRequest;
    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequest;
    void removeCategory(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
}
