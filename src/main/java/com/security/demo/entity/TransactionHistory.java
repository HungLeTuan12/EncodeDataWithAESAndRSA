package com.security.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
// Bang chua cac thong tin ve lich su giao dich
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "in_debt")
    private Double inDebt;

    @Column(name = "have")
    private Double have;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;
}
