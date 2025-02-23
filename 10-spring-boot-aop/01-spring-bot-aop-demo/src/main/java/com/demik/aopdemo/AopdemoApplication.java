package com.demik.aopdemo;

import com.demik.aopdemo.Service.TrafficFortuneService;
import com.demik.aopdemo.dao.AccountDAO;
import com.demik.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO,
												MembershipDAO membershipDAO,
												TrafficFortuneService trafficFortuneService) {
		return runner -> {

			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheReturningAdvice(accountDAO);

//			demoTheAfterThrowingAdvice(accountDAO);

			//demoTheAroundAdvice(trafficFortuneService);

			demoTheAroundAdviceHandleException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain program: AroundDemoAppException");
		System.out.println("Calling getFortune");

		String data = trafficFortuneService.getFortune(true);

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain program: AroundDemoApp");
		System.out.println("Calling getFortune");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			accounts = accountDAO.findAccounts(false);
		}
		catch (Exception e) {
			System.out.println("Main program caught exception: " + e);
		}

		System.out.println("After throwing");
		System.out.println(accounts);
		System.out.println("\n");


	}

	private void demoTheReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts(true);

		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		Account account = new Account();
		account.setName("Damian");
		account.setLevel("Platinum");

		boolean vip = true;

		accountDAO.addAccount(account, vip);
		membershipDAO.addAccount();
		accountDAO.doWork();

		accountDAO.setName("nigre");
		accountDAO.setServiceCode("12");

		accountDAO.getName();
		accountDAO.getServiceCode();
	}

}
