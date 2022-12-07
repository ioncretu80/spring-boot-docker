package com.icr.springbootdocker.service;

import com.icr.springbootdocker.model.Transaction;
import com.icr.springbootdocker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Iterable<Transaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }
}
