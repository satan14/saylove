package kits_khu13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import khu13entity.AccountEntity;
import khu13entity.SiteEntity;
import khu13respository.Khu13RepositoryImpl;

public class Admin {
	static Scanner scan = new Scanner(System.in);
	public void signin() {
		AccountEntity acc = new AccountEntity();
		Khu13RepositoryImpl khu13repimpl = new Khu13RepositoryImpl();
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
	public void showSite() {
		Khu13RepositoryImpl khu13RepositoryImpl = new Khu13RepositoryImpl();
		List<SiteEntity> list = new ArrayList();
		list =khu13RepositoryImpl.findAll();
		System.out.println("Please select your seat!");
		for(int i=0;i<list.size();i++){
			if(!list.get(i).getStatus().equalsIgnoreCase("full")) {
				System.out.println(list.get(i).getId()+"."+list.get(i).getSite() + ": "+list.get(i).getStatus());
			}
			
		}
	}
}
