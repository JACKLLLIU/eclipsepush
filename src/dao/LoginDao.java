package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import bean.admin;
import bean.users;
import until.DButil;
import until.JDBCuntil;

public class LoginDao {

	public static admin queryAdmin(String username, String password) {
		Connection con = null;
		try {
			con = JDBCuntil.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql = "select * from admin where adminname ='" + username + "' and adminpsd ='" + password + "'";
		admin admin = null;
		try {
			PreparedStatement pres = con.prepareStatement(sql);
			ResultSet rs = pres.executeQuery(sql);
			if (rs.next()) {
				admin = new admin();
				admin.setId(rs.getInt("id"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setTelephone(rs.getString("telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}

	public static users queryUsers(String username, String password) {
		Connection con = DButil.getConnection();
		String sql = "select * from users where username ='" + username + "' and password ='" + password + "'";
		users user = null;
		try {
			PreparedStatement pres = con.prepareStatement(sql);
			ResultSet rs = pres.executeQuery(sql);
			if (rs.next()) {
				user = new users();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setLicenseplate(rs.getString("licenseplate"));
				user.setTelephone(rs.getString("telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public static boolean queryUser(int id,String psd1,String psd2) {
		Connection con = null;
		String sql1 = "select 1 from users where users.id =? and users.password =? ";
		String sql2 = "UPDATE users set users.`password` = ? where users.id = ?";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql1);
			pres.setInt(1, id);
			pres.setString(2, psd1);
			boolean a = pres.execute();
			PreparedStatement pres1 = con.prepareStatement(sql2);
			pres1.setString(1, psd2);
			pres1.setInt(2, id);
			int b = pres1.executeUpdate();
			if(a) {
				if(b>0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return false;
	}
	
	
	public static boolean addUser(String username, String password) {
		Connection con = null;
		String sql = "insert into users(username,password) VALUES('"+username+"','"+password+"')";
		try {
			 con = JDBCuntil.getConnection();
			 PreparedStatement pres = con.prepareStatement(sql);
			 boolean flag = pres.execute(sql);
			 if(!flag) {
				 return true;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static admin queryAdminById(int id) {
		Connection con = null;
		String sql = "select * from admin where admin.id = ?";
		admin admin = null;
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, id);
			ResultSet rs = pres.executeQuery();
			if(rs.next()) {
				admin = new admin();
				admin.setId(rs.getInt("id"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setTelephone(rs.getString("telephone"));
			}
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
