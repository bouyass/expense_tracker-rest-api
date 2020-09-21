package com.example.expensetrackerapi.services;

import com.example.expensetrackerapi.exceptions.EtAuthException;
import com.example.expensetrackerapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        return null;
    }
}
