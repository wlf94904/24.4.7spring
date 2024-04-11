package com.itheima.utils;

/**
 * 一个用于记录日志的类
 * @author 86131
 *
 */
public class Logger {

	/**
	 * 记录日志的操作
	 * 计划让其业务核心方法（切入点方法）执行之前执行
	 */
	public void printLog() {
		System.out.println("Logger中的printLog方法开始记录日志了。。。。。");
	}
}
