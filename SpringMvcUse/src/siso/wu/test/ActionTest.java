package siso.wu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import siso.wu.dao.JDBCDAO;
import siso.wu.model.UserInfo;

public class ActionTest {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		JDBCDAO dao= (JDBCDAO)applicationContext.getBean("jdbcDAO"); 
		
		/*UserInfo userInfo = new UserInfo();
		userInfo.setUser_id(1);
		userInfo.setName("wu");
		userInfo.setPhone("123456");
		userInfo.setEmail("827937686@qq.com");
		dao.insert(userInfo);*/
	    System.out.println(dao.queryList());
		 
	}
}
