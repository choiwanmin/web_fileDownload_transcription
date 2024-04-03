package dataroom.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dataroom.DataRoom;
import dataroom.DataRoomService;

/**
 * Servlet implementation class DataRoomAdd
 */
@WebServlet("/dataroom/add")
public class DataRoomAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataRoomAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("/dataroom/add.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		int size = 100 * 1024 * 1024;
		MultipartRequest multipart = new MultipartRequest(request, DataRoomService.path, size, "utf-8",
				new DefaultFileRenamePolicy());

		String writer = multipart.getParameter("writer");
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		File f = multipart.getFile("fname");
		String fname = f.getName();

		DataRoom d = new DataRoom(0, writer, null, title, content, fname, 0);
		System.out.println(d);

		DataRoomService service = new DataRoomService();
		service.addData(d);

		response.sendRedirect(request.getContextPath() + "/dataroom/list");

	}

}
