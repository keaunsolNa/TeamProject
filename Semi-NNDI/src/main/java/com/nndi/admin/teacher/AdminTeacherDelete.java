package com.nndi.admin.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login/admin/deleteTeacher.do")
public class AdminTeacherDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("강사삭제 컨트롤러");
		
//		int no = Integer.valueOf(request.getParameter("no"));
		String no = request.getParameter("no");
		
		System.out.println("가져왔니 " + no);
		
		TeacherService teacherService = new TeacherService();
		
		int result = teacherService.deleteTeacher(no);
		
		if(result>0) {
			response.sendRedirect("teacherList");
			System.out.println("success");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/selectErrorPage/UpdateFail.jsp").forward(request, response);
			System.out.println("fail");
		}
	
	
	}

}
