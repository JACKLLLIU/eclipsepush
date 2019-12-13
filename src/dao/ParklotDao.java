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
		String sql = "select * from parkinglot";
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
}
