package com.learning.designpattern.structural;

class Bank {
    public void processPayment(String accountNumber, double amount) {
        System.out.println("Processing payment of $" + amount + " from account: " + accountNumber);
    }
}

interface CreditCard {
    void makePayment(String cardNumber, double amount);
}

class BankAdapter implements CreditCard {
    private Bank bank;

    public BankAdapter(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void makePayment(String cardNumber, double amount) {
        // Adapts the cardNumber to the accountNumber format used by the Bank
        String accountNumber = "ACC-" + cardNumber;
        bank.processPayment(accountNumber, amount);
    }
}

public class StructuralPattern {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adapter to make the bank system compatible with CreditCard interface
        CreditCard creditCard = new BankAdapter(bank);

        // Make payment using the CreditCard interface
        creditCard.makePayment("1234-5678-9012", 250.00);
    }
}
