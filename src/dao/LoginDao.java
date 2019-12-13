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
	public static DataSource ds = null;
	// 初始化C3P0数据源
	static {
		// 使用c3p0-config.xml配置文件中的named-config节点中name属性的值
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		ds = cpds;
	}

	public static admin queryAdmin(String username, String password) {
		Connection con = null;
		try {
			con = JDBCuntil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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

}