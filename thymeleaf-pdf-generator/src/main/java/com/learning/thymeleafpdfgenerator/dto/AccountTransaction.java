package com.learning.thymeleafpdfgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransaction {
    private String date;
    private String particulars;
    private double debit;
    private double credit;
    private double balance;
}
