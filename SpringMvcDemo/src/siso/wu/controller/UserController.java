package siso.wu.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siso.wu.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("----µÇÂ¼ÑéÖ¤---");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		Cookie cookie=new Cookie("user",userName+"-"+password);
		cookie.setMaxAge(1*60*60*24*7);
		User currentUser=new User(userName,password);
		response.addCookie(cookie);
		HttpSession session=request.getSession();
		session.setAttribute("currentUser", currentUser);
		return "redirect:/main.jsp";
	}
	
	@RequestMapping("/login2")
	public String login2(HttpServletRequest request){
		return "redirect:/main.jsp";
	}
	
	@RequestMapping("/login3")
	public String login3(HttpSession session){
		return "redirect:/main.jsp";
	}
	
	@RequestMapping("/ajax")
	public @ResponseBody User ajax(){
		User user=new User("zhangsan","123");
		return user;
	}
}
