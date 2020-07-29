package kits_khu13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import khu13entity.AccountEntity;
import khu13entity.MenuEntity;
import khu13entity.SiteEntity;
import khu13respository.Khu13Repository;
import khu13respository.Khu13RepositoryImpl;

public class Admin {
	static Scanner scan = new Scanner(System.in);
	MenuEntity menuE = new MenuEntity();
	Khu13RepositoryImpl khu13RepositoryImpl = new Khu13RepositoryImpl();
	public void showSite() {
		Khu13RepositoryImpl khu13RepositoryImpl = new Khu13RepositoryImpl();
		List<SiteEntity> list = new ArrayList();
		list =khu13RepositoryImpl.findAll();
		System.out.println("Show empty site");
		for(int i=0;i<list.size();i++){
			if(!list.get(i).getStatus().equalsIgnoreCase("full")) {
				System.out.println(list.get(i).getId()+"."
			+list.get(i).getSite() + ": "
						+list.get(i).getStatus());
			}
			
		}
	}
	public void changeMenu() {
		System.out.println("Do you want to change the menu? y/n");
		String changemenu = scan.next();
		if(changemenu.equals("y")) {
			System.out.println("Change Combo?");
			int idM = scan.nextInt();
			menuE.setId(idM);
			System.out.println("Change price?");
			int price = scan.nextInt();
			menuE.setPrice(price);
			khu13RepositoryImpl.changeprice(menuE);
		}else {
			
		}
	}
}
