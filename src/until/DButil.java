package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DButil {
	public static void main(String[] args) {
		DButil.getConnection();
	}
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//通过java驱动管理类，获得mysql驱动管理类的对象
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "123456");
			System.out.println("连接成功");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
