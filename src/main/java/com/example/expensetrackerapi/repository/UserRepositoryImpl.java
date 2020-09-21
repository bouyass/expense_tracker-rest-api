package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.exceptions.EtAuthException;
import com.example.expensetrackerapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public User findByEmailandPassword(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }
}
