package com.security.demo.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
// Request from user about transaction
public class TransactionRequest {
    @NotNull(message = "Id can not null")
    private String transactionId;
    @NotNull(message = "Account can not null")
    private String account;
    @NotNull(message = "Debt can not null")
    private Double inDebt;
    private Double have;
    private LocalDateTime time;
}
