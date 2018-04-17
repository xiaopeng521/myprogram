package cn.tedu.ems.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements 
HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, Object arg2)
					throws Exception {
		System.out.println("开始session验证...");
		HttpSession session = 
				request.getSession();
		Object obj = 
				session.getAttribute("user");
		if(obj == null){
			//没有登录，重定向到登录页面
			System.out.println("没有登录，重定向到登录页面...");
			response.sendRedirect("toLogin.do");
			return false;
		}
		//登录过了，则继续向后执行。
		System.out.println("登录过了，则继续向后执行");
		return true;
	}
	

}




