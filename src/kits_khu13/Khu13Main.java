package kits_khu13;

import khu13entity.SiteEntity;
import khu13respository.Khu13Repository;
import khu13respository.Khu13RepositoryImpl;

public class Khu13Main {
public static void main(String[] args) {
	Admin ad = new Admin();
	ad.signin();
	ad.showSite();
	Khu13Repository k = new Khu13RepositoryImpl();
	SiteEntity siteE = new SiteEntity();
	k.update(siteE);
}
}
