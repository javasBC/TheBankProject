package com.example.demo.DAO;

import com.example.demo.POJO.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account){
        System.out.println("account added");
    }

}
