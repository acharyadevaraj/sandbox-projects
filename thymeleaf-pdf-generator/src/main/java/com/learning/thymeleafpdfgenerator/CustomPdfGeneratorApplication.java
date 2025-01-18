package com.learning.thymeleafpdfgenerator;

import com.learning.thymeleafpdfgenerator.dto.AccountTransaction;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomPdfGeneratorApplication {

    public static final List<AccountTransaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(CustomPdfGeneratorApplication.class, args);
    }

    @PostConstruct
    public void init() {

        LocalDate currentDate = LocalDate.of(2024, 2, 8); // Start date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Insert 10 records
        for (int i = 1; i <= 1000; i++) {
            AccountTransaction transaction = null;
            if (i % 2 == 0) {
                transaction = new AccountTransaction(
                        currentDate.format(formatter),
                        "Interests Savings\n" +
                                "Interest Earned  ",
                        100.00 * i,
                        0,
                        500.00 * i
                );
            } else {
                transaction = new AccountTransaction(
                        currentDate.format(formatter),
                        "Interests Savings\n" +
                                "Interest Earned  ",
                        0,
                        50.00 * i,
                        500.00 * i
                );
            }

            transactions.add(transaction);

            // Increment date for the next transaction
            currentDate = currentDate.minusDays(1);
        }
    }
}
