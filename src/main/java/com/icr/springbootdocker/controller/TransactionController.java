package com.icr.springbootdocker.controller;

import com.icr.springbootdocker.model.Transaction;
import com.icr.springbootdocker.service.TransactionService;
import jakarta.transaction.InvalidTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/create")
    public Long createTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return transaction.getTransactionId();
    }

    @GetMapping("/viewAll")
    public Iterable<Transaction> viewAllTransactions() {
        return transactionService.getTransactionHistory();
    }

    @GetMapping("/view/{id}")
    public Transaction viewTransactionById(@PathVariable("id") Long id) {
        Optional<Transaction> transaction = transactionService.getTransaction(id);
        if(transaction.isPresent()) {
            return transaction.get();
        }

        throw new InvalidTransationReferenceException("Invalid transaction reference provided");

    }

}

