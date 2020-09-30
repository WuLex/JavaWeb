package wu.ioc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class WebAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
 
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public void setServletRequest(HttpServletRequest arg0) {
		 this.request=arg0;
	}
 
	public void setServletContext(ServletContext arg0) {
		 this.servletContext=arg0;
	}
 
	public void setServletResponse(HttpServletResponse arg0) {
		 this.response=arg0;
	}
	
	public String execute() throws Exception {
		 this.request.setAttribute("", "");
		 this.servletContext.setAttribute("","");
		 HttpSession session=request.getSession();
		 session.setAttribute("", ""); 
		return SUCCESS;
	}
  
}
