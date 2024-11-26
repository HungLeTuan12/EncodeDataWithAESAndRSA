package com.security.demo.service;

import com.security.demo.encode.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logTransactionException(String transactionId, String account, double inDebt, double have, Exception e) {
        logger.error("Error processing transaction. Details: " +
                        "TransactionID: {}, Account: {}, InDebt: {}, Have: {}, Time: {}",
                LogUtils.maskSensitiveData(transactionId),
                LogUtils.maskSensitiveData(account),
                "?", // Che số tiền nợ
                "?", // Che số tiền có
                "?"); // Che thời gian
        logger.error("Exception: ", e);
    }
}
