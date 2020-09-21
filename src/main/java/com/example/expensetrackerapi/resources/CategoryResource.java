package com.example.expensetrackerapi.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @GetMapping("")
    public String getAllCategories(HttpServletRequest request){
        System.out.println(request.getAttribute("userId"));
        int userId = (Integer) request.getAttribute("userId");
        return "Authneticated user " + userId;
    }

}
