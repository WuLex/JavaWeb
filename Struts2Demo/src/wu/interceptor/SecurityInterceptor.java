package wu.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecurityInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	    ActionContext actionContext=ActionContext.getContext();
	    Map sessionMap=actionContext.getSession();
	    String currentUser=(String)sessionMap.get("admin");
	    if(currentUser==null){
	         //û�е�¼
	    	return  Action.LOGIN;
	    }
	    else
	    {
	    	//�Ѿ���¼
	    	return invocation.invoke();
	    	
	    } 
	}

}
