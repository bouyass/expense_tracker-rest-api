package com.example.expensetrackerapi.resources;

import com.example.expensetrackerapi.model.Category;
import com.example.expensetrackerapi.services.CategorySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    CategorySerivce categorySerivce;

    @GetMapping("")
    public List<Category> getAllCategories(HttpServletRequest request){
        System.out.println(request.getAttribute("userId"));
        int userId = (Integer) request.getAttribute("userId");
        List<Category> categoryList = categorySerivce.fetchAllCategories(userId);
        return categoryList;
    }

    @PostMapping("addCategory")
    public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String , Object> categoryMap){
        int userId = (Integer) request.getAttribute("userId");
        String title  = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categorySerivce.addCategory(userId, title, description);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findCategoryById(HttpServletRequest request, @PathVariable Integer categoryId){
        return new ResponseEntity<>(categorySerivce.fetchCategoryById((Integer)request.getAttribute("userId"),categoryId), HttpStatus.FOUND);
    }

    @PutMapping("/update/{categoryId}")
    public String updateCategory(HttpServletRequest request, @RequestBody Category category, @PathVariable Integer categoryId){
        Integer userId = (Integer) request.getAttribute("userId");
        categorySerivce.updateCategory(userId, categoryId,category );
        return "Resource updated";
    }

}
