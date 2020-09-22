package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.exceptions.EtBadRequest;
import com.example.expensetrackerapi.exceptions.EtResourceNotFoundException;
import com.example.expensetrackerapi.model.Transaction;


public interface TransactionRepository {
    Integer create(Integer categoryId, Integer userId, Double amount, String note, Long transaction_date) throws EtBadRequest;
    Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
