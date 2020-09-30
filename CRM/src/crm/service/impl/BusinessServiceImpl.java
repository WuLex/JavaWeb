package crm.service.impl;

import crm.dao.UserDao;
import crm.dao.impl.UserDaoImpl;
import crm.domain.User;
import crm.exception.UserExistException;
import crm.utils.ServiceUtils;

//6  对web层提供所有的业务服务
public class BusinessServiceImpl {

	private UserDao dao=new UserDaoImpl();//工厂模式   spring
	//对web层提供注册服务
	public void register(User user) throws UserExistException{
		boolean b=dao.find(user.getUsername());
		if(b){
			throw new UserExistException("用户已经存在！");
			//用户存在，给web层抛出编译时异常
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	//对web层提供登录服务
	public User login(String username,String password){
		password=ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
}
