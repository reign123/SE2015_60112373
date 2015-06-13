package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
		
	@Autowired
	private LoginService service;
	
	@RequestMapping(value = "/LoginController/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("id");
		String userpwd = request.getParameter("pwd");
		User user = new User();
		
		user.setID(userid);
		user.setPassword(userpwd);
		
		int flag = service.login(user);
		request.getSession().setAttribute("user", user);
		if(flag == 1){
			return "student";
		}else if(flag == 2 ){
			return "professor";
		}else if(flag == 3){
			return "manager";
		}else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/LoginController/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if (session.getAttribute("sessionUser") != null) {
			session.removeAttribute("sessionUser");
		}
		return "redirect:/";
	}
}
