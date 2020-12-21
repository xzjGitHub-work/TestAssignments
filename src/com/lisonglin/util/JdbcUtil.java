package com.lisonglin.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {

	public static final ComboPooledDataSource ds=new ComboPooledDataSource();
	
	static 
	{
		//加载连接数据库的信息
		try {
			InputStream is =new FileInputStream("jdbcinfo.config");
			Properties porp =new Properties();
			porp.load(is);
			is.close();
			//获取连接数据库信息
			String user =porp.getProperty("user");
			String pwd =porp.getProperty("pwd");
			String url=porp.getProperty("url");
			String driver =porp.getProperty("driver");
			//设置链接库的信息
			ds.setUser(user);
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setPassword(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void release(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
