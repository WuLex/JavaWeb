package wu.modeldriven;

import wu.model.Userinfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<Userinfo>,Action {

	private Userinfo info=new Userinfo(); //ģ�ͱ���ʵ����
	public Userinfo getModel() {
		 
		return null;
	}
	 
	public String execute() throws Exception {
		 
		return null;
	}

}
