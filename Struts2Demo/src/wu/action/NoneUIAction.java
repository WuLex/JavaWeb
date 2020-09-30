package wu.action;

import java.util.List;

import wu.Dao.MctypeDAO;
import wu.model.Mctype;

import com.opensymphony.xwork2.ActionSupport;

public class NoneUIAction extends ActionSupport {
   private List<Mctype> allTypes;
   public List<Mctype> getAllTypes() {
		return allTypes;
	}
	public void setAllTypes(List<Mctype> allTypes) {
		this.allTypes = allTypes;
	}
	
	
   @Override
	public String execute() throws Exception {
	   MctypeDAO dao=new MctypeDAO(); 
	   allTypes =dao.getAllType();
	   return SUCCESS;
	}

   
    
}
