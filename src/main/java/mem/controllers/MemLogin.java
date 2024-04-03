package mem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mem.Mem;
import mem.MemService;

/**
 * Servlet implementation class MemLogin
 */
@WebServlet("/mem/login")
public class MemLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("/mem/login.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemService service = new MemService();
		Mem m = service.getMem(id);

		String msg = "";
		String path = "/mem/login.jsp";
		if (m == null) {
			msg = "아이디 오류";
		} else {
			if (pwd.equals(m.getPwd())) {
				msg = "로그인 성공";
				HttpSession session = request.getSession();
				session.setAttribute("loginId", id);
				String type = "판매자";

				if (m.getType() == 1) {
					type = "구매자";
				}
				session.setAttribute("loginType", type);
				path = "/index.jsp";
			} else {
				msg = "비밀번호 오류";
			}
		}
		request.setAttribute("msg", msg);

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
