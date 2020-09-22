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
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    CategorySerivce categorySerivce;

    @GetMapping("")
    public String getAllCategories(HttpServletRequest request){
        System.out.println(request.getAttribute("userId"));
        int userId = (Integer) request.getAttribute("userId");
        return "Authenticated user " + userId;
    }

    @PostMapping("addCategory")
    public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String , Object> categoryMap){
        int userId = (Integer) request.getAttribute("userId");
        String title  = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categorySerivce.addCategory(userId, title, description);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

}
