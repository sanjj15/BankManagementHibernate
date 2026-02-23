package com.wipro.bank.bean;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="bank_account")
public class TransferBean {

    @Id
    @Column(name="account_no")
    private String fromAccountNumber;

    @Transient  
    private String toAccountNumber;

    @Transient   // Not stored in DB
    private double amount;

    @Transient
    private Date dateOfTransaction;

    @Column(name="balance")
    private double balance;

    // Getters and Setters

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}