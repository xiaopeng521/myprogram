package cn.tedu.ems.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;

/**
 * 业务层实现类
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="userDAO")
	private UserDAO dao;
	
	public User checkLogin(
			String uname, String pwd) {
		User user = dao.findByUsername(uname);
		if(user == null){
			/*
			 * 抛出应用异常:
			 * (了解)
			 * 	因为用户错误的操作引起的异常，
			 *  需要明确提示用户采取正确的操作。
			 */
			throw new AppException("用户名不存在");
		}
		if(!user.getPassword().equals(pwd)){
			throw new AppException("密码错误");
		}
		return user;
	}

}


