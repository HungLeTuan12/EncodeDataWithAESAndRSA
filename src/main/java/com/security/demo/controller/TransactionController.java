package com.security.demo.controller;

import com.security.demo.dto.request.TransactionRequest;
import com.security.demo.service.LoggingService;
import com.security.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private LoggingService loggingService;

   // Description: thuc hien giao dich voi so tai khoan nguon va dich
    // se duoc ma hoa AES
    // tao ra 2 ban ghi, mot ban ghi nguon se luu thong tin ve no
    // 1 ban ghi se luu thong tin have (nhan)
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestParam String transactionId,
            @RequestParam String sourceAccount,
            @RequestParam String destinationAccount,
            @RequestParam double amount) {
        try {
            transactionService.saveTransferTransaction(transactionId, sourceAccount, destinationAccount, amount);
            return ResponseEntity.ok("Transaction completed successfully!");
        } catch (Exception e) {
            loggingService.logTransactionException(transactionId, sourceAccount, amount, 0.0, e);
            return ResponseEntity.status(500).body("Transaction failed due to an internal error.");
        }
    }
}
