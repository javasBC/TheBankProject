package com.example.demo;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.POJO.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var context =
				SpringApplication.run(DemoApplication.class, args);

		var acccount =context.getBean(AccountDAO.class);
		var customer =context.getBean(CustomerDAO.class);

		acccount.addAccount(new Account());
		customer.addCustomer();

	}

}
