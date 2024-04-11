package com.itheima.utils;

import java.util.ResourceBundle;

/**
 * 数据库操作相关的工具类
 * @author 86131
 *
 */
public class JDBCUtil {
	
//	使用ResourceBundle读取资源文件
	private static ResourceBundle bundle=ResourceBundle.getBundle("dbconfig");

	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	//使用静态代码块进行赋值
	static {
		driver=bundle.getString("DRIVER");
		url=bundle.getString("URL");
		user=bundle.getString("USER");
		password=bundle.getString("PASSWORD");
	}
}
