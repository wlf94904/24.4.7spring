package com.itheima.dataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义连接池
 * @author 86131
 *
 */
public class MyDataSource {
	//定义一个池，用于存放连接
	private static List<Connection> pool=Collections.synchronizedList(new ArrayList<Connection>());//把ArrayList转成线程安全的
	
	//使用静态代码块给池中加入连接
	static {
		for(int i=0;i<10;i++) {
			Connection conn=JDBCUtil.getConnection();
			pool.add(conn);
		}
	}
	
	/**
	 * 获取一个连接
	 */
	public static Connection getConnection() {
		final Connection conn=pool.remove(0);
		//创建代理对象
		Connection proxyConn=(Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(),
				conn.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object rtValue=null;
						//1.判断当前方法是不是close方法
						if("close".equals(method.getName())) {
							//不能直接关闭
							pool.add(conn);
						}else {
							rtValue=method.invoke(conn, args);
						}
						return rtValue;
					}
				});
	}
	
	/**
	 * 获取池中的连接数
	 */
	public static int getPoolSize() {
		return pool.size();
	}
}