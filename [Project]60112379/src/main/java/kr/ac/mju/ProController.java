package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProController {
	
	@Autowired
	private ProService service;
	
	@RequestMapping(value = "/ProController/openclass", method = RequestMethod.POST)
	public String openclass(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		Pro pro = new Pro();
		
		pro.setNo((String) request.getParameter("no"));
		pro.setProname((String) request.getParameter("proname"));
		pro.setName((String) request.getParameter("name"));
		pro.setYear((String) request.getParameter("year"));
		pro.setGrade((String) request.getParameter("grade"));
		pro.setMax((String) request.getParameter("max"));
		pro.setCredit((String) request.getParameter("credit"));
		
		service.openclass(pro);
		return "professor";
	}
	
	@RequestMapping(value = "/ProController/openclasspage", method = RequestMethod.GET)
	public String viewclasspage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		return "openclass";
	}
	
	@RequestMapping(value = "/ProController/gradegrant", method = RequestMethod.GET)
	public String gradegrant(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("no");
		ArrayList<RegistForCourse> List = null;
		
		List = service.grantGrade(no);
		request.setAttribute("grantList", List);
		return "gradeview_professor";
	}
	
	@RequestMapping(value = "/ProController/grantgrade", method = RequestMethod.GET)
	public String grantGrade(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		String stuname = request.getParameter("name");
		String classname = request.getParameter("classname");
		String grade = request.getParameter("classgrade");
		
		RegistForCourse rfc = new RegistForCourse();
		rfc.setClassGrade(grade);
		rfc.setStudentname(stuname);
		rfc.setClassname(classname);
		
		service.Grade(rfc);
		
		return "professor";
	}
	
	@RequestMapping(value = "/ProController/gradegrantpage", method = RequestMethod.GET)
	public String viewgradepage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		ArrayList<Pro> pro = null;
		pro = service.List();
		request.setAttribute("proList", pro);
		System.out.println("LOG");
		return "gradegrant_Professor";
	}
}
