package kr.ac.sungkyul.emillist.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.emaillist.web.EmailListActionFactory;
import kr.ac.sungkyul.web.Action;

@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");

		Action action = new EmailListActionFactory().getAction(actionName);
		action.execute(request, response);

		// if ("form".equals(actionName)) {
		// // forwarding
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/WEB-INF/views/form.jsp");
		// rd.forward(request, response);
		// } else if ("insert".equals(actionName)) {
		// request.setCharacterEncoding("utf-8");
		// String firstName = request.getParameter("fn");
		// String lastName = request.getParameter("ln");
		// String email = request.getParameter("email");
		//
		// EmailListVo vo = new EmailListVo();
		// vo.setFirstName(firstName);
		// vo.setLastName(lastName);
		// vo.setEmail(email);
		//
		// EmailListDao dao = new EmailListDao();
		// dao.insert(vo);
		//
		// response.sendRedirect("/emaillist2/el");
		// } else {
		// EmailListDao dao = new EmailListDao();
		// List<EmailListVo> list = dao.getList();
		//
		// // request 범위(scope)에 list 객체를 저장
		// request.setAttribute("list", list);
		//
		// // forwarding
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/WEB-INF/views/list.jsp");
		// rd.forward(request, response);
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}