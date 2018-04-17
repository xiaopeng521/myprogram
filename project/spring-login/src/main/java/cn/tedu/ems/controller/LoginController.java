package cn.tedu.ems.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.AppException;
import cn.tedu.ems.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,
			HttpSession session){
		System.out.println("login()");
		String username = 
				request.getParameter("uname");
		String pwd = 
				request.getParameter("pwd");
		System.out.println("username:" 
				+ username + " pwd:" + pwd);
		
		//将登录请求分发给业务层的对象来处理
		try{
			User user = 
					loginService.checkLogin(
							username, pwd);
			//登录成功，绑订数据到session
			session.setAttribute("user", user);
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，需要明确提示用户采取正确的操作
				request.setAttribute("login_failed",
						e.getMessage());
				return "login";
			}
			//系统异常
			return "error";
		}
		//登录成功，重定向到首页
		return "redirect:toIndex.do";
	}
	
	
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}









