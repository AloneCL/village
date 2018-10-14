/**
 * 
 */
package test;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zm.village.dao.Admin;
import zm.village.service.AdminService;

/**
* @ClassName: AdminTest.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 下午8:31:32 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class AdminTest {
    
	@Autowired
	private AdminService service;
	
	@Test
	public void logintest(){
		Admin admin = new Admin();
		System.out.println(service+"\n"+admin);
		System.out.println(1111);
		admin.setUsername("admin");
		admin.setPassword("123");
		System.out.println(service.login(admin));
	}
}
