package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.exceptions.EtAuthException;
import com.example.expensetrackerapi.model.User;

public interface UserRepository {
    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
    User findByEmailandPassword(String email, String password) throws EtAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
}
