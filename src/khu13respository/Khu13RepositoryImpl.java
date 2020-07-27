package khu13respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khu13config.Khu13Config;
import khu13entity.AccountEntity;
import khu13entity.SiteEntity;
import kits_khu13.Login;
import kits_khu13.User;

public class Khu13RepositoryImpl implements Khu13Repository {
	private Connection connection =null;
	private PreparedStatement pstmt = null;
	private ResultSet result = null;
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = Khu13Config.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<SiteEntity> findAll() {
		List<SiteEntity> list = new ArrayList<>();
		String queryString = "SELECT * FROM site";
		try {
			connection= getConnection();
			pstmt =connection.prepareStatement(queryString);
			result=pstmt.executeQuery();
			while(result.next()) {
				
				SiteEntity siteE = new SiteEntity();
				siteE.setId(result.getInt(1));
				siteE.setSite(result.getString("site"));
				siteE.setStatus(result.getString("status"));
				list.add(siteE);
			
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}

	
	@Override
	public AccountEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SiteEntity siteE) {
		 	try {
				String queString = "update site set status = ? " + " where id=?";
				User us = new User();
				int id = us.selectSite();
				connection = getConnection();
				pstmt = connection.prepareStatement(queString);
				pstmt.setString(1, "full");
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
				System.out.print("ok");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void checklog(AccountEntity acc) {
		try {
			connection=getConnection();
			String queryString = "SELECT * FROM account WHERE name = ? and password= ?";
			pstmt =connection.prepareStatement(queryString);
			pstmt.setString(1, acc.getName());
			pstmt.setString(2, acc.getPassword());
			result=pstmt.executeQuery();
			if(result.next()) {
				System.out.println("Your access: "+result.getString(2));
				acc.setAccess(result.getString(2));
//				System.out.println(acc.getAccess());
			}
			else {
				System.out.println("Error!!!");
				Login again = new Login();
				again.login();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// TODO Auto-generated method stub
	
	}
	public void add(AccountEntity acc) {
		try {
			String queryString = "Insert Into " + "account(access,name,password,phone,typeofaccess)"
			    	+"Values(?,?,?,?,?)";
						connection = getConnection();
						pstmt = connection.prepareStatement(queryString);
						pstmt.setString(1,"user");
						pstmt.setString(2,acc.getName());
						pstmt.setString(3,acc.getPassword());
//						pstmt.setInt(4,acc.getMoney());
						pstmt.setString(4,acc.getPhone());
						pstmt.setString(5,"1");
						pstmt.executeUpdate();
						if(result.next()) {
							
						}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}
