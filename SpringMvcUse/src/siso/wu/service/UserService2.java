package siso.wu.service;

import siso.wu.dao.IUserDAO;

public class UserService2 {
	 private  IUserDAO dao;
	 public String name;
	
	 public  UserService2(IUserDAO paradao,String paraname){
		 this.dao=dao;
		 this.name=name;
	 }
	  
	 public void remove()
	   {
		 System.out.println("remove");
		  dao.RemoveUser();
	   }

		private void dobefore() {
			 System.out.println("³õÊ¼»¯");
		}
		
		private void doafter() {
			 System.out.println("Ïú»Ù");
		}
}
