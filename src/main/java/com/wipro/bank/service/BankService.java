package com.wipro.bank.service;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.util.*;

public class BankService {

    BankDAO dao = new BankDAO();

    public double checkBalance(String accNo)
            throws AccountNotFoundException {

        return dao.checkBalance(accNo);
    }

    public boolean transfer(TransferBean bean)
            throws InsufficientFundException, AccountNotFoundException {

        return dao.transfer(bean);
    }
}