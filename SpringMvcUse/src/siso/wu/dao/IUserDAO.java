package siso.wu.dao;

import siso.wu.model.UserInfo;

public interface IUserDAO {
	public void saveUser(UserInfo info);
	
   public String RemoveUser();

   
}
