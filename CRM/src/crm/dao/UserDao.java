package crm.dao;

import crm.domain.User;

public interface UserDao {

	  void add(User user);

	  User find(String username, String password);

	//����ע����û��Ƿ������ݿ��д���
	  boolean find(String username);

}