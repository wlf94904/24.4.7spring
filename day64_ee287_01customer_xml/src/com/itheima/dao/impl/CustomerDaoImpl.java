package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;

/**
 * 客户的持久层实现类
 * @author 86131
 *
 */
public class CustomerDaoImpl implements ICustomerDao {
	
	private QueryRunner runner=new QueryRunner();

	@Override
	public List<Customer> findAllCustomer() {
		try {
			return runner.query("select * from cst_customer",new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		try {
			runner.update("insert into cst_customer(cust_name,cust_industry,cust_level,cust_address,cust_phone)values(?,?,?,?,?,?)",
					customer.getCust_name(),customer.getCust_source(),customer.getCust_industry(),
					customer.getCust_level(),customer.getCust_address(),customer.getCust_phone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			runner.update("update cst_customer set cust_name=?,cust_industry=?,cust_level=?,cust_address=?,cust_phone=? where cust_id=?",
					customer.getCust_name(),customer.getCust_source(),customer.getCust_industry(),
					customer.getCust_level(),customer.getCust_address(),customer.getCust_phone(),customer.getCust_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public void deleteCustomer(Long custId) {
		try {
			runner.update("delete from cst_customer where cust_id=?",custId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public Customer findCustomerById(Long custId) {
		try {
			return runner.query("select * from cst_customer where cust_id=?",new BeanHandler<Customer>(Customer.class),custId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
