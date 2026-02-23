package com.wipro.bank.main;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.service.BankService;
import com.wipro.bank.util.AccountNotFoundException;
import com.wipro.bank.util.InsufficientFundException;

public class BankMain {

    public static void main(String[] args) {

        BankService bankService = new BankService();

        try {
            System.out.println("Initial Balance (From): " + bankService.checkBalance("12345678"));

            TransferBean transferBean = new TransferBean();
            transferBean.setFromAccountNumber("12345678");
            transferBean.setAmount(880);
            transferBean.setToAccountNumber("12345687");
            transferBean.setDateOfTransaction(new java.util.Date());

            System.out.println("Transfer Status: " + bankService.transfer(transferBean));
            System.out.println("Updated Balance from: " + bankService.checkBalance("12345678"));
            System.out.println("Updated Balance to: " + bankService.checkBalance("12345687"));

        } catch (InsufficientFundException e) {
            System.out.println("ERROR: " + e.getMessage());

        } catch (AccountNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}