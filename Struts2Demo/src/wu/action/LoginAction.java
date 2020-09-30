package wu.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
    private String	username;
    private String	password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception {
		 System.out.println("输入的用户名:"+username);
		 System.out.println("输入的密码:"+password);
		 return null;
	}

}
