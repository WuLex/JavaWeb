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
		 System.out.println("��ʼ��");
	}
	
	private void doafter() {
		 System.out.println("����");
	}
	
   
}
