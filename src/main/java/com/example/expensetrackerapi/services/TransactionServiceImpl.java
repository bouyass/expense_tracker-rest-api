package com.example.expensetrackerapi.services;

import com.example.expensetrackerapi.model.Transaction;
import com.example.expensetrackerapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements  TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Integer categoryId, Integer userId, Double amount, String note, Long transaction_date) {
        int transactionId = transactionRepository.create(categoryId, userId, amount, note, transaction_date);
        return fetchById(userId,categoryId,transactionId);
    }

    @Override
    public Transaction fetchById(Integer userId, Integer categoryId, Integer transactionId) {
        return transactionRepository.findById(userId,categoryId,transactionId);
    }
}
