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
		model.addAttribute("message", "StringMvc��ã�");
		return new ModelAndView("helloWorld");
		
	}
	
	 @RequestMapping("/welcome")
	    public String welcome() {
	         return "/welcome";
	    }
	 
	     //URLӳ��
		 /** 
	     * �������ҪModel��ֱ�ӷ�String���򵥣���Ӧ��viewΪhello.jsp 
	     */ 
	    @RequestMapping(value="/hello", method = RequestMethod.GET)
	    public String hello() {
	        return "/hello";
	    }
	 
	 //�����ַ���һ��Map����
	 /**
	      * @see ʹ��map��Ϊ����ֵ��ʱ�� ����prefixǰ׺+requestMapping��value+suffix��׺��� ����һ��map
	      *      ,map��put���������൱��request.setAttribute����
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