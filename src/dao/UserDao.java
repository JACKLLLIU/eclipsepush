package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import bean.users;
import until.JDBCuntil;

public class UserDao {
	
	public static boolean updateUser(String tname,String licenseplate,String age,String sex,String telephone,String id) {
		Connection con = null;
		String sql = "update users set tname = ?,licenseplate =?,age=?,sex=?,telephone=? where id = ?";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setString(1,tname);
			pres.setString(2,licenseplate);
			pres.setString(3,age);
			pres.setString(4,sex);
			pres.setString(5,telephone);
			pres.setString(6,id);
			System.out.println(pres.toString());
			int i = pres.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static users queryUser(int id) {
		Connection con = null;
		users user = null;
		String sql = "select * from users where id = ?";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, id);
			System.out.println(pres.toString());
			ResultSet rs  = pres.executeQuery();
			if(rs.next()) {
				user = new users();
				user.setName(rs.getString("tname"));
				user.setLicenseplate(rs.getString("licenseplate"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getString("age"));
				user.setTelephone(rs.getString("telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public static List<users> queryAllUser() {
		Connection con = null; 
		String sql ="select * from users";
		List<users> list = new ArrayList<users>();
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			ResultSet rs = pres.executeQuery();
			while(rs.next()) {
				users users = new users();
				users.setId(rs.getInt("id"));
				users.setUsername(rs.getString("username"));
				users.setName(rs.getString("tname"));
				users.setLicenseplate(rs.getString("licenseplate"));
				users.setAge(rs.getString("age"));
				users.setSex(rs.getString("sex"));
				users.setTelephone(rs.getString("telephone"));
				list.add(users);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
	}
	
	public static boolean deleteUser(int id) {
		Connection con = null; 
		String sql ="DELETE from users where users.id = ?";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, id);
			int i = pres.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}
	
	public static boolean Resetpsd(int id) {
		Connection con = null; 
		String sql = "update users SET users.`password` = '123456' where users.id = ?";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, id);
			int i = pres.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
