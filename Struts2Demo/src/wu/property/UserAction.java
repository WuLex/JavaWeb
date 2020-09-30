package wu.property;

import wu.model.Userinfo;

import com.opensymphony.xwork2.Action;

public class UserAction implements Action  {
    private Userinfo info;
	public Userinfo getInfo() {
		return info;
	}
	public void setInfo(Userinfo info) {
		this.info = info;
	}
	public String execute() throws Exception {
		 
		return null;
	}

}
