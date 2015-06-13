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
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/StudentController/RFCpage", method = RequestMethod.GET)
	public String viewPage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<Pro> pro = null;
		pro = service.rfcview();
		
		request.setAttribute("proList", pro);
		return "rfcpage";
	}
	
	
	
	@RequestMapping(value = "/StudentController/gradeview", method = RequestMethod.GET)
	public String gradeviewPage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<RegistForCourse> rfc = null;
		rfc = service.gradeview();
		
		request.setAttribute("rfc", rfc);
		return "gradeview_Student";
	}
	
	@RequestMapping(value = "/StudentController/RFC", method = RequestMethod.POST)
	public String RegistForCourse(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		RegistForCourse rfc = new RegistForCourse();
		ArrayList<Pro> pro = null;
		
		String stuName = request.getParameter("stuname");
		String className = request.getParameter("classname");
		String classNo = request.getParameter("classnum");
		String proName = request.getParameter("proname");
		String year = request.getParameter("year");
		String grade = request.getParameter("grade");
		String credit = request.getParameter("credit");
		String max = request.getParameter("max");
		
		rfc.setStudentname(stuName);
		rfc.setClassname(className);
		rfc.setNo(classNo);
		rfc.setProname(proName);
		rfc.setYear(year);
		rfc.setGrade(grade);
		rfc.setCredit(credit);
		rfc.setMax(max);
		
		service.rfc(rfc);
		
		pro = service.rfcview();
		request.setAttribute("proList", pro);
		request.setAttribute("RFC", rfc);
		
		return "rfcpage";
	}
	
}
