package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.occupy;
import bean.subscribe;
import until.JDBCuntil;

public class OccupyDao {
	public static List<occupy> queryOccupyById(int id) {
		Connection con = null;
		String sql = "select * FROM occupy where occupy.id= ?";
		occupy occupy = null;
		List<occupy> list = null;
		try {
			con = JDBCuntil.getConnection();
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, id);
			ResultSet rs = pres.executeQuery();
			list = new ArrayList<occupy>();
			while(rs.next()) {
				occupy = new occupy();
				occupy.setId(rs.getInt("id"));
				occupy.setLocation(rs.getString("location"));
				list.add(occupy);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
