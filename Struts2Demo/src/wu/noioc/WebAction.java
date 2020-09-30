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
		 //获取WEB对象
		//1.获取作用域中的属性
		
		ActionContext  actionContext=ActionContext.getContext();
		Map requestMap=(Map)actionContext.get("request");
		Map sessionMap=actionContext.getSession();
		Map applicationMap=actionContext.getApplication();
		
		//1.1 操作作用域中的属性：get put remove
		requestMap.put("str", "requestStr");
		sessionMap.put("str", "sessionStr");
		applicationMap.put("str", "applicationStr");
		//1.2获取所有请求的参数
		Map<String,Object> paramMap=actionContext.getParameters();
		System.out.println( ((String[])paramMap.get("task"))[0] );
		//1.3获取WEB对象
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		ServletContext contex=ServletActionContext.getServletContext();
		 
		return SUCCESS;
	}
	
}
