package com.demik.aopdemo.dao;

import com.demik.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + "NIGGERNEGEROWE");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": 🐔🐔🐔🐔");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": 🙀🙀🙀🙀");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": 🐧🐧🐧🐧");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": 🐌🐌🐌🐌");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": 🦏🦏🦏🦏");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {

        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luca", "Gold");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

    @Override
    public List<Account> findAccounts(boolean b) {

        if (b) {
            throw new RuntimeException("No soup for you");
        }

        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luca", "Gold");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }
}
