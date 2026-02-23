package com.wipro.bank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.HibernateUtil;
import com.wipro.bank.util.InsufficientFundException;

public class BankDAO {

    public double checkBalance(String accNo) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        TransferBean account = session.get(TransferBean.class, accNo);
        session.close();

        if (account != null)
            return account.getBalance();

        return 0;
    }

    @SuppressWarnings("deprecation")
	public boolean transfer(TransferBean transferBean) throws InsufficientFundException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        TransferBean from = session.get(TransferBean.class,
                transferBean.getFromAccountNumber());

        TransferBean to = session.get(TransferBean.class,
                transferBean.getToAccountNumber());

        if (from == null || to == null) {
            session.close();
            return false;
        }

        if (from.getBalance() < transferBean.getAmount()) {
            session.close();
            throw new InsufficientFundException("Insufficient Balance!");
        }

        from.setBalance(from.getBalance() - transferBean.getAmount());
        to.setBalance(to.getBalance() + transferBean.getAmount());

        session.update(from);
        session.update(to);

        tx.commit();
        session.close();

        return true;
    }
}