package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;


@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
 
    @Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.insertUser(user);
	}
    @Override
	public boolean loginByName(String username, String password) {
    	User user;
    	try {
    		user= userDAO.findUserByNameAndPsw(username,password);   
    		 
    		if (user==null) {//说明查无此人
    			return false;
			}else{//查找到当前用户了
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		  
    	return false;
	}

}