package khu13respository;

import java.util.List;

import khu13entity.AccountEntity;
import khu13entity.MenuEntity;
import khu13entity.SiteEntity;

public interface Khu13Repository {
	List<SiteEntity> findAll();
	List<MenuEntity> findMenu();
	SiteEntity findById(int id);
	AccountEntity checklog(String name, String pw);
	MenuEntity checkprice(int id);
	SiteEntity update(SiteEntity siteE);
	int delete();
	MenuEntity updatemoney(int money, String name);
	MenuEntity changeprice(MenuEntity menuE);
	
}
