package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Users;
import until.DButil;

public class DAOtest {
	
	public static boolean selectID() throws SQLException {
		Connection con = DButil.getConnection();
		String sql = "select s.course_id,AVG(s.score) avgscore,MAX(s.score) maxscore,MIN(s.score) minscore from score s GROUP BY s.student_id";
		QueryRunner queryRunner = new QueryRunner();
		queryRunner.query(con, sql,new BeanListHandler<>(Users.class));
		
		con.close();
		return false;
	}
	
	// 添加数据
	/*
	 * public void add(Order order) throws Exception { 
	 * Connection connection = JDBCUtils.getConnection(); 
	 * String sql = "insert into order1(id) values(?)";
	 * qr.update(connection, sql, order.getId()); }
	 * 
	 * 
	 *  
	public List<Order> findAllUser() throws SQLException {
		String sql = "select * from order1";
		return qr.query(sql, new BeanListHandler<Order>(Order.class));
	}
	
	
	public void update(Order order) throws SQLException {
		String sql = "update order1 set state=? where id=?";
		qr.update(sql, order.getState(), order.getId());
	}
	
	
	public void deleteById(String id) throws SQLException {
		String sql = "delete from order1 where id=?";
		qr.update(sql, id);
 
	}
	
	 */
}
