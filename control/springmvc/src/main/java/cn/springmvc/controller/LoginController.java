package cn.springmvc.controller; 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;


@Controller
@RequestMapping("/")
public class LoginController {
 
	@Autowired
	public UserService uss;	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request) {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result=uss.loginByName(username, password);
		if (result) {
			System.out.println("login success");
			return "success";
		}else{
			System.out.println("login faile");
			return "faile";
		}	 
	}
	@RequestMapping("updateuserinfo")
	@ResponseBody
	public String updateInfo(HttpServletRequest request) {
		String []str=new String[5]; 
		str[0] = request.getParameter("phone");
		str[4] = request.getParameter("username");
		str[1] = request.getParameter("email");
		str[2] = request.getParameter("address");
		str[3] = request.getParameter("imgurl");  
		boolean result=uss.updateUserInfo(str);
		if (result) {
			System.out.println("update success");
			return "success";
		}else{
			System.out.println("update faile");
			return "faile";
		}	 
	}
	@RequestMapping("selectUserInfo")
	@ResponseBody
	public List<User> selectUserImage(HttpServletRequest request) {
		List<User> list=new ArrayList<User>();
		String username = request.getParameter("username");   
		list=uss.selectUserInfo(username);
		return list;	 
	}
	 
}
