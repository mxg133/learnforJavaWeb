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

		Connection conn = source1.getConnection();
		return conn;
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
