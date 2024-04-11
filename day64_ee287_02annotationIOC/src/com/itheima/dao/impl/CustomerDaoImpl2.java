package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.dao.ICustomerDao;
/**
 * 模拟客户的持久层实现类
 * @author 86131
 *
 */
@Repository("customerDao2")
public class CustomerDaoImpl2 implements ICustomerDao{

	@Override
	public void saveCustomer() {
		System.out.println("持久层保存了客户222222222222222");
	}
}
