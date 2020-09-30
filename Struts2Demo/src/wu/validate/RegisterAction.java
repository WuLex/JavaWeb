package wu.validate;

import wu.model.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport  {
  private Userinfo model=new Userinfo();
  
  public Userinfo getModel()
  {
	  return model;
  }
  
  @Override
	public void validate() {
		//进行客户端的表单验证
		if(model.getSuser()==null||model.getSuser().trim().length()<=0)
		{
			this.addFieldError("SUSER", "用户名必须输入!");
		}
		else if(model.getSuser().trim().length()<6||model.getSuser().trim().length()>16)
		{
			this.addFieldError("suser", "用户名必须在6-16之间");
		}
		
	}
  
  public String register() throws Exception
  {
	  return SUCCESS;
	  
  }
  
}
