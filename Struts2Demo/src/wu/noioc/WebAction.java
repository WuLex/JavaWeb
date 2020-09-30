package wu.noioc;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

 

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WebAction extends ActionSupport {
   
	public String execute() throws Exception {
		 //��ȡWEB����
		//1.��ȡ�������е�����
		
		ActionContext  actionContext=ActionContext.getContext();
		Map requestMap=(Map)actionContext.get("request");
		Map sessionMap=actionContext.getSession();
		Map applicationMap=actionContext.getApplication();
		
		//1.1 �����������е����ԣ�get put remove
		requestMap.put("str", "requestStr");
		sessionMap.put("str", "sessionStr");
		applicationMap.put("str", "applicationStr");
		//1.2��ȡ��������Ĳ���
		Map<String,Object> paramMap=actionContext.getParameters();
		System.out.println( ((String[])paramMap.get("task"))[0] );
		//1.3��ȡWEB����
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		ServletContext contex=ServletActionContext.getServletContext();
		 
		return SUCCESS;
	}
	
}
