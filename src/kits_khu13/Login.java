package kits_khu13;

import java.util.Scanner;

import khu13entity.AccountEntity;
import khu13respository.Khu13RepositoryImpl;

public class Login {
	static Scanner scan = new Scanner(System.in);
	AccountEntity acc = new AccountEntity();
	Khu13RepositoryImpl khu13repimpl = new Khu13RepositoryImpl();
	public void creat() {
		
		System.out.println("What's your name?");
		String username = scan.next();
		acc.setName(username);
		System.out.println("What's your password?");
		String pass = scan.next();
		acc.setPassword(pass);
//		System.out.println("How much?");
//		int money = scan.nextInt();
//		acc.setMoney(money);
		System.out.println("What's your numberphone: ");
		String phone = scan.next();
		acc.setPhone(phone);
		khu13repimpl.add(acc);
	}
	public void login() {
		
//		AccountEntity meo = new AccountEntity();
		System.out.println("Your Name: ");
		String logname = scan.next();
		acc.setName(logname);
		System.out.println("Your Password: ");
		String logpass = scan.next();
		acc.setPassword(logpass);
		khu13repimpl.checklog(acc);
		acc.setAccess(acc.getAccess());
		System.out.println(acc.getAccess());
//		System.out.println(acc.getName());
//		if(meo.getName().equals(logname)) {
//			System.out.println(meo.getName());
//		}
//		else {
//			System.out.println("no");
//		}
	}
}
