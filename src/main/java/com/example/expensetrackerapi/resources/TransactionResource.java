package com.example.expensetrackerapi.resources;

import com.example.expensetrackerapi.model.Transaction;
import com.example.expensetrackerapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionResource {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/addTransaction")
    public ResponseEntity<Transaction> addTransaction(HttpServletRequest request, @RequestBody Map<String, Object> tansactionMap){
        Integer userId = (Integer) request.getAttribute("userId");
        Integer categoryId = (Integer) tansactionMap.get("categoryId");
        Double amount  = (Double) tansactionMap.get("amount");
        String note = (String) tansactionMap.get("note");
        Integer transaction_date = (Integer) tansactionMap.get("transaction_date");
        Transaction transaction = transactionService.addTransaction(categoryId, userId, amount, note, Long.parseLong(transaction_date.toString(),10));
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
