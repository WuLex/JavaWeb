package wu.action;

import wu.model.Userinfo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<Userinfo> {
  private Userinfo info=new Userinfo();

 
public Userinfo getModel() {
	 
	return info;
}
  
 public String resgister() throws Exception
 {
	return SUCCESS; 
 }
  
}
