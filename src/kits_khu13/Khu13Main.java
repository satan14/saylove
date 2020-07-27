package kits_khu13;

import java.util.Scanner;

import khu13entity.AccountEntity;
import khu13entity.SiteEntity;
import khu13respository.Khu13Repository;
import khu13respository.Khu13RepositoryImpl;

public class Khu13Main {
	static Scanner scan = new Scanner(System.in);
public static void main(String[] args) {
	System.out.println("****Welcome KHU13****");
	System.out.println("Do you have an account? y/n");
	String answer = scan.next();
	Login log = new Login();
	if(answer.equals("n")) {
		log.creat();
	}
	else {
		log.login();
	}
	Khu13RepositoryImpl khu13Repository = new Khu13RepositoryImpl();
	AccountEntity acc = new AccountEntity();
	System.out.println(acc.getAccess());
	

	
//	Admin ad = new Admin();
//	ad.showSite();
//	Khu13Repository k = new Khu13RepositoryImpl();
//	SiteEntity siteE = new SiteEntity();
//	k.update(siteE);
}
}
