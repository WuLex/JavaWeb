package siso.wu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import siso.wu.dao.IUserDAO;

public class TestIOC {
    public static void main(String[] args) {
    	ApplicationContext applicationContext=null;
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	    IUserDAO  dao=(IUserDAO)applicationContext.getBean("user_oracle");
	    // IUserDAO  dao=(IUserDAO)applicationContext.getBean("user_sqlserver");
	    dao.RemoveUser();
    }
}
