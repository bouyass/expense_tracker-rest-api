package com.example.expensetrackerapi.services;

import com.example.expensetrackerapi.model.Transaction;

import java.util.Date;
import java.util.Iterator;

public interface TransactionService {
    Transaction addTransaction(Integer categoryId, Integer userId, Double amount, String note, Long transaction_date);
    Transaction fetchById(Integer userId, Integer categoryId, Integer transactionId);
}
