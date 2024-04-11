package com.itheima.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.NonWritableChannelException;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.transform.impl.UndeclaredThrowableStrategy;

/**
 * 模拟一个剧组
 * @author 86131
 *
 */
public class Client {

	public static void main(String[] args) {
		Actor actor=new Actor();
//		actor.basicAct(100f);
//		actor.dangerAct(500f);

		/**
		 * 动态代理：
		 * 作用：不改变源码的基础上，对已有方法增强。（它是AOP思想的实现技术）
		 * 分类：
		 * 		基于接口的动态代理：
		 * 				要求：被代理类最少实现一个接口
		 * 				提供者：JDK官方
		 * 				涉及的类：Proxy
		 * 			创建代理对象的方法：newProxyInstance(ClassLoader, Class[], InvocationHandler)
		 * 				参数的含义：
		 * 					ClassLoader:类加载器，和被代理对象使用相同的类加载器.一般都是固定写法。
		 * 						Class[]:字节码数组。被代理类实现的接口。（要求代理对象和被代理对象具有相同的行为）。一般都是固定写法。
		 * 			InvocationHandler:它是一个接口，就是用于我们提供增强代码的，我们一般都是写一个该接口的实现类。实现类可以是匿名内部类
		 * 							它的含义就是：如何代理。此处的代码只能是谁用谁提供。
		 * 							策略模式：
		 * 								使用要求：数据已经有了
		 * 									目的明确
		 * 									达成目标的过程就是策略
		 * 								在dbutils中的ResultSetHandler就是策略模式的具体应用。
		 * 			基于子类的动态代理:
		 * 				要求：被代理类不能是最终类，不能被final修饰
		 * 				提供者：第三方CGlib
		 * 				涉及的类：Enhancer
		 * 				创建代理对象的方法：create(Class,Callback);
		 * 				参数的含义：
		 * 					Class:被代理对象的字节码
		 * 					Callback：如何代理。它和InvocationHandler的作用是一样的。它也是一个接口，我们一般使用该接口的子接口MethodInterceptor
		 * 							在使用时我们也是创建该接口的匿名内部类
		 */
		Enhancer.create(actor.getClass(),new MethodInterceptor() {
			/**
			 * 执行被代理对象的任何方法，都会经过该方法。它和基于接口动态代理的invoke方法的作用是一模一样的
			 * 方法的参数：
			 * 	前面三个和invoke方法的参数含义和作用都一样
			 */
			@Override
			public Object inObject(Object proxy,Method method,Object[] args,MethodProxy methodProxy) throws Throwable{
				return null;
			}
		});
	}

}
