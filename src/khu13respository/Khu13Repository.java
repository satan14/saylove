package khu13respository;

import java.util.List;

import khu13entity.AccountEntity;
import khu13entity.SiteEntity;

public interface Khu13Repository {
	List<SiteEntity> findAll();
	AccountEntity findById(int id);
	
	void update(SiteEntity siteE);
	int delete();
}
