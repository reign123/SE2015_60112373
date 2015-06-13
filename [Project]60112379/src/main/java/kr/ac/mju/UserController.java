package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@RequestMapping(value = "/UserController/dataInsert", method = RequestMethod.POST)
	public String dataInsert(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		User user = new User();
		user.setID((String) request.getParameter("id"));
		user.setPassword((String) request.getParameter("pwd"));
		user.setName((String) request.getParameter("name"));
		user.setPos((String) request.getParameter("pos")); 
		service.insertData(user);
		
		logger.info("Insert");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/UserController/createDB", method = RequestMethod.POST)
	public String createDB(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createDB();
		return "user";
	}
	
	@RequestMapping(value = "/loginController/login", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createDB();
		return "redirect:/";
	}

	@RequestMapping(value = "/UserController/createTable", method = RequestMethod.POST)
	public String createTable(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createTable();
		return "user";
	}
	
	@RequestMapping(value = "/UserController/createTable2", method = RequestMethod.POST)
	public String createTable2(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createTable2();
		return "user";
	}
	
	@RequestMapping(value = "/UserController/createTable3", method = RequestMethod.POST)
	public String createTable3(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createTable3();
		return "user";
	}
	
	@RequestMapping(value = "/UserController/dropAccount", method = RequestMethod.POST)
	public String dropAccount(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.dropAccount();
		return "user";
	}
		
	@RequestMapping(value = "/UserController/userPage", method = RequestMethod.GET)
	public String userpage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		return "user";
	}
	
	@RequestMapping(value = "/UserController/regist", method = RequestMethod.GET)
	public String regist(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		return "regist";
	}

	@RequestMapping(value = "/UserController/createAccount", method = RequestMethod.GET)
	public String createAccount(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createAccount();
		return "user";
	}

	@RequestMapping(value = "/UserController/dropTable", method = RequestMethod.POST)
	public String dropTable(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		service.dropTable();
		return "user";
	}
	
	@RequestMapping(value = "/UserController/dropTable2", method = RequestMethod.POST)
	public String dropTable2(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		service.dropTable2();
		return "user";
	}

	@RequestMapping(value = "/UserController/dropDB", method = RequestMethod.POST)
	public String dropDB(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		service.dropDB();
		return "user";
	}
}
