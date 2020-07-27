package kits_khu13;

import java.util.Scanner;

import khu13entity.SiteEntity;
 
public class User {
//	SiteEntity st = new SiteEntity();
	static Scanner scan = new Scanner(System.in);
	public int selectSite() {
		int selectS = scan.nextInt();
//		st.setId(selectS);		
		return selectS; 
	}
}
