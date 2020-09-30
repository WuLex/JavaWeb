package momo.action;

import java.util.List;

import momo.model.MenuInfo;
import momo.model.UserInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange.Map;

public class IndexAction extends ActionSupport {

	private List<MenuInfo> menus;
	
	public String usermenu() {
		Map<E, F> map=ActionContext.getContext().getSession();
		UserInfo info=(UserInfo)map.get("admin");
		IUserDAO dao=new UserDAOImpl();
		
	}
	
}
