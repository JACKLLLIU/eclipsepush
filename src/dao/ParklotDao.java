package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.parkinglot;
import until.JDBCuntil;

public class ParklotDao {
	public static List<parkinglot> qAllParklot() {
		Connection con = null;
		parkinglot parkinglot = null;
		List<parkinglot> list = new ArrayList<parkinglot>();
		String sql = "select * from parkinglot ";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement prs = con.prepareStatement(sql);
			ResultSet rs = prs.executeQuery();
			while(rs.next()) {
				parkinglot = new parkinglot();
				parkinglot.setId(rs.getInt("id"));
				parkinglot.setLocation(rs.getString("location"));
				parkinglot.setStatus(rs.getInt("status"));
				list.add(parkinglot);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean subscribe(int rowid,int userid) {
		Connection con = null;
		String sqlupdate = "update parkinglot set status = 2 where id = ? ";
		String sqlinset = "insert into subscribe values(?,(select parkinglot.location FROM parkinglot where parkinglot.id =? ))";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sqlupdate);
			PreparedStatement pres1 = con.prepareStatement(sqlinset);
			pres.setInt(1, rowid);
			System.out.println(pres.toString());
			pres1.setInt(1, userid);
			pres1.setInt(2, rowid);
			int a = pres.executeUpdate();
			int b = pres1.executeUpdate();
			if(a>0&&b>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean delete(int id) {
		Connection con = null;
		//删除subscribe表中的数据
		String sql1 = "DELETE FROM subscribe where subscribe.location = (SELECT parkinglot.location from parkinglot where parkinglot.id = ?)";
		//再去删除parkinglot表中的
		String sql2 = "DELETE from parkinglot where parkinglot.id = ? ";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql1);
			pres.setInt(1, id);
			pres.executeUpdate();
			PreparedStatement pres1 = con.prepareStatement(sql2);
			pres1.setInt(1, id);
			int a = pres1.executeUpdate();
			if(a>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean add(String location,int status) {
		Connection con = null;
		String sql="insert into parkinglot(location,status)values(?,?) ";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setString(1,location);
			pres.setInt(2, status);
			int flag = pres.executeUpdate();
			if(flag>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean reset(int id) {
		Connection con = null;
		String sql = "update parkinglot set parkinglot.`status` = 0 where parkinglot.id = ?;";
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
}
