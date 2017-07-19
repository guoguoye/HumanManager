package hrm.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hrm.domain.User;
import hrm.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/{pathname}")
	public String loginForm(@PathVariable("pathname") String pathname){
		return pathname;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView mv){
		
		User user = userService.login(loginname, password);
		if(user!=null){
			session.setAttribute("user", user);
			mv.setViewName("main");
		}
		else{
			mv.addObject("message", "用户名密码不匹配");
			mv.setViewName("loginForm");
		}
		return mv;
	}
}
