package wu.ioc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseWebAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpSession session;
	
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	private HttpServletResponse response;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

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
