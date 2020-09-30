package siso.wu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import siso.wu.dao.IUserDAO;
import siso.wu.service.UserService;

public class TestDI {
	public static void main(String[] args) {
    	ApplicationContext applicationContext=null;
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	    UserService service=(UserService)applicationContext.getBean("user_service");
	    service.remove();
	    UserService service1=(UserService)applicationContext.getBean("user_service");
	    UserService service2=(UserService)applicationContext.getBean("user_service");
	    
	    System.out.println(service1.hashCode());
	    System.out.println(service2.hashCode());
	    
	    ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
