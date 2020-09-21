package com.example.expensetrackerapi.services;

import com.example.expensetrackerapi.exceptions.EtAuthException;
import com.example.expensetrackerapi.model.User;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
