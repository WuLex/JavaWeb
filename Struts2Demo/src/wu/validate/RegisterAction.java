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
		//���пͻ��˵ı���֤
		if(model.getSuser()==null||model.getSuser().trim().length()<=0)
		{
			this.addFieldError("SUSER", "�û�����������!");
		}
		else if(model.getSuser().trim().length()<6||model.getSuser().trim().length()>16)
		{
			this.addFieldError("suser", "�û���������6-16֮��");
		}
		
	}
  
  public String register() throws Exception
  {
	  return SUCCESS;
	  
  }
  
}
