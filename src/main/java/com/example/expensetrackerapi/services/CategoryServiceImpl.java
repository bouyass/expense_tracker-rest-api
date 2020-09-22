package com.example.expensetrackerapi.services;

import com.example.expensetrackerapi.exceptions.EtBadRequest;
import com.example.expensetrackerapi.exceptions.EtResourceNotFoundException;
import com.example.expensetrackerapi.model.Category;
import com.example.expensetrackerapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements  CategorySerivce {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        return categoryRepository.findAll(userId);
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequest {
        int categoryId = categoryRepository.create(userId, title, description);
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequest {
        categoryRepository.update(userId,categoryId,category);
    }

    @Override
    public void removeCategory(Integer userId, Integer categoryId) throws EtResourceNotFoundException {

    }
}
