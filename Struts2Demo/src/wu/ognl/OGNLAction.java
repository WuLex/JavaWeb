package wu.ognl;

import com.opensymphony.xwork2.ModelDriven;

import wu.ioc.BaseWebAction;

public class OGNLAction extends BaseWebAction implements ModelDriven<UserInfo> {

	 private UserInfo model=new UserInfo();
	public UserInfo getModel() {
		 return model;
	}
	 
	public String execute() throws Exception {
		 this.getRequest().setAttribute("", "");
		 this.getSession().setAttribute("", "");
		
		 model.setUsername("wu");
		 model.setPassword("12345");
		 
		 return SUCCESS;
	}

}
