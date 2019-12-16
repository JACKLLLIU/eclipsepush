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
				sub.setId(rs.getInt(id));
				sub.setLocation(rs.getString("location"));
				list.add(sub);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
