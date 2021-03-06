package siso.wu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
 
	@RequestMapping("/helloWorld")
	public ModelAndView  helloWorld(Model model){
		model.addAttribute("message", "StringMvc你好！");
		return new ModelAndView("helloWorld");
		
	}
	
	 @RequestMapping("/welcome")
	    public String welcome() {
	         return "/welcome";
	    }
	 
	     //URL映射
		 /** 
	     * 如果不需要Model，直接返String更简单，对应的view为hello.jsp 
	     */ 
	    @RequestMapping(value="/hello", method = RequestMethod.GET)
	    public String hello() {
	        return "/hello";
	    }
	 
	 //第四种返回一个Map集合
	 /**
	      * @see 使用map作为返回值的时候 是以prefix前缀+requestMapping的value+suffix后缀组成 返回一个map
	      *      ,map的put方法调用相当于request.setAttribute方法
	      * */
	     @RequestMapping("/mapa")
	     public Map<String, Object> mapa(ModelMap map1) {
	  
	         Map<String, Object> map = new HashMap<String, Object>();
	         //UserBean bean = new UserBean();
	        /* bean.setId(1);
	         bean.setUsername("Edward Lau");
	         bean.setPassword("edward");
	         map.put("hello", "world key");
	         map.put("user", bean);*/
	         return map;
	     }
}
