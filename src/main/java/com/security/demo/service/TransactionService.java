package com.security.demo.service;

import com.security.demo.encode.AESUtils;
import com.security.demo.entity.TransactionHistory;
import com.security.demo.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Value("${aes.secret-key}") // Khóa bí mật lấy từ cấu hình
    private String aesSecretKey;

    @Autowired
    private TransactionHistoryRepository repository;

    /**
     * Luu thong tin cua moi giao dich voi so tai khoan duoc ma hoa theo AES
     * @param transactionId: id cua giao dich
     * @param sourceAccount: tai khoan nguon gui tien
     * @param destinationAccount: tai khoan goc nhan tien
     * @param amount: so tien
     * @throws Exception
     */
    public void saveTransferTransaction(String transactionId, String sourceAccount, String destinationAccount, double amount) throws Exception {
        // Mã hóa số tài khoản
        String encryptedSourceAccount = AESUtils.encrypt(sourceAccount, aesSecretKey);
        String encryptedDestinationAccount = AESUtils.encrypt(destinationAccount, aesSecretKey);

        // Giao dịch nợ cho tài khoản nguồn
        TransactionHistory debtTransaction = new TransactionHistory();
        debtTransaction.setTransactionId(transactionId);
        // Ma hoa so tai khoan nguon
        debtTransaction.setAccount(encryptedSourceAccount);
        debtTransaction.setInDebt(amount);
        debtTransaction.setHave(0.0);
        debtTransaction.setTime(LocalDateTime.now());
        repository.save(debtTransaction);

        // Giao dịch có cho tài khoản đích
        TransactionHistory creditTransaction = new TransactionHistory();
        creditTransaction.setTransactionId(transactionId);
        // Ma hoa tai khoan dich
        creditTransaction.setAccount(encryptedDestinationAccount);
        creditTransaction.setInDebt(0.0);
        creditTransaction.setHave(amount);
        creditTransaction.setTime(LocalDateTime.now());
        repository.save(creditTransaction);
    }
}
