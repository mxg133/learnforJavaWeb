package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//import org.apache.commons.dbutils.DbUtils;
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
	/**
	 *
	 * @Description 获取数据库的连接
	 * @return
	 * @throws Exception
	 */

	/**
	 * 使用Druid数据库连接池技术
	 */
	private static DataSource source1;

	private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

	static{
		try {
			Properties pros = new Properties();

			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

			pros.load(is);

			source1 = DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection3Druid() throws SQLException{

		Connection conn = conns.get();

		if (conn == null) {
			conn = source1.getConnection();//从数据库连接池中获取连接
			conns.set(conn);//// 保存到ThreadLocal对象中，供后面的jdbc操作使用 相对最后一次保存有效！
			conn.setAutoCommit(false);// 设置为手动管理事务
		}

		return conn;
	}

	/**
	 * 提交事务，并关闭释放连接
	 */
	public static void commitAndClose() {
		Connection conn = conns.get();
		if (conn != null) {// 如果不等于null，说明 之前使用过连接，操作过数据库
			try {
				conn.commit();// 提交 事务
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				try {
					conn.close();// 关闭连接，资源资源
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
		// 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
		conns.remove();

	}

	/**
	 * 回滚事务，并关闭释放连接
	 */
	public static void rollbackAndClose() {
		Connection conn = conns.get();
		if (conn != null) {// 如果不等于null，说明 之前使用过连接，操作过数据库
			try {
				conn.rollback();// 回滚事务
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				try {
					conn.close();// 关闭连接，资源资源
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
		// 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
		conns.remove();
	}

	/**
	 *
	 * @Description 关闭连接和Statement的操作
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn,Statement ps){
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @Description 关闭资源操作
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource(Connection conn,Statement ps,ResultSet rs){
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @Description 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource1(Connection conn,Statement ps,ResultSet rs){
//		try {
//			DbUtils.close(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(rs);
	}

}
