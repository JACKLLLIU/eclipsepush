package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.subscribe;
import until.JDBCuntil;

public class SubscribeDao {
	public static List<subscribe> QueryByid(int id) {
		Connection con = null;
		String sql = "select * FROM subscribe where subscribe.id= ?";
		subscribe sub = null;
		List<subscribe> list = null;
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, id);
			ResultSet rs = pres.executeQuery();
			list = new ArrayList<subscribe>();
			while(rs.next()) {
				sub = new subscribe();
				sub.setId(rs.getInt("id"));
				sub.setLocation(rs.getString("location"));
				list.add(sub);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean cancelSub(String location) {
		Connection con = null;
		String sql1 = "DELETE FROM subscribe where subscribe.location = ? ";
		String sql2 = "UPDATE parkinglot set parkinglot.`status` = 0 where parkinglot.location =  ?";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres1 = con.prepareStatement(sql1);
			pres1.setString(1,location);
			int a = pres1.executeUpdate();
			PreparedStatement pres2 = con.prepareStatement(sql2);
			pres2.setString(1, location);
			int b = pres2.executeUpdate();
			if(a>0&&b>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean occupypark(int id,String location) {
		Connection con = null;
		String sql1 = "DELETE FROM subscribe where subscribe.location = ? ";
		String sql2 = "UPDATE parkinglot set parkinglot.`status` = 1 where parkinglot.location =  ?";
		String sql3 = "INSERT into parkingrecord(parkingrecord.id,parkingrecord.location,parkingrecord.licenseplate,parkingrecord.entryTime)VALUES(?,?,(SELECT users.licenseplate FROM users where users.id = ?),CURRENT_TIMESTAMP)";
		String sql4 = "INSERT INTO occupy(occupy.id,occupy.location)VALUES(?,?)";
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres1 = con.prepareStatement(sql1);
			pres1.setString(1, location);
			int a = pres1.executeUpdate();
			PreparedStatement pres2 = con.prepareStatement(sql2);
			pres2.setString(1, location);
			int b = pres2.executeUpdate();
			PreparedStatement pres3 = con.prepareStatement(sql3);
			pres3.setInt(1,id);
			pres3.setString(2,location);
			pres3.setInt(3, id);
			int c = pres3.executeUpdate();
			PreparedStatement pres4 = con.prepareStatement(sql4);
			pres4.setInt(1, id);
			pres4.setString(2, location);
			int d = pres4.executeUpdate();
			if(a>0&&b>0&&c>0&&4>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
