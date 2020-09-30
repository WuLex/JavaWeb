package siso.wu.service;
import siso.wu.dao.IUserDAO;

public class UserService {
   private  IUserDAO dao;
   public void setDao(IUserDAO dao) {
		this.dao = dao;
	}
   
	public void remove()
   {
	  dao.RemoveUser();
   }

	private void dobefore() {
		 System.out.println("³õÊ¼»¯");
	}
	
	private void doafter() {
		 System.out.println("Ïú»Ù");
	}
	
   
}
