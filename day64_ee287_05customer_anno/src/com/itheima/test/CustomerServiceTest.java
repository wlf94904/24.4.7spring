package com.itheima.test;

import static org.junit.Assert.fail;
import config.SpringConfiguration;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
/**
 * 测试客户的业务层
 * @author zhy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class CustomerServiceTest {

	@Resource(name="customerService")
	private ICustomerService cs;
	
	@Test
	public void testFindAllCustomer() {
		ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs=(ICustomerService) ac.getBean("customerService");
		List<Customer> list = cs.findAllCustomer();
		for(Customer c : list){
			System.out.println(c);
		}
	}

	@Test
	public void testSaveCustomer() {
		ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs=(ICustomerService) ac.getBean("customerService");
		Customer c = new Customer();
		c.setCust_name("dbutils customer annotation");
		cs.saveCustomer(c);
	}

	@Test
	public void testUpdateCustomer() {
		ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs=(ICustomerService) ac.getBean("customerService");
		Customer c = cs.findCustomerById(94L);
		c.setCust_address("北京市顺义区");
		cs.updateCustomer(c);
	}

	@Test
	public void testDeleteCustomer() {
		cs.deleteCustomer(96l);
	}

	@Test
	public void testFindCustomerById() {
		Customer c = cs.findCustomerById(94L);
		System.out.println(c);
	}

}
