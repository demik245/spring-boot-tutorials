package com.demik.aopdemo.dao;

import com.demik.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);
    boolean doWork();
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
    List<Account> findAccounts(boolean b);
    List<Account> findAccounts();
}
