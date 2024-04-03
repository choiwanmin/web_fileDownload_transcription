package dataroom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataroom.DataRoom;
import dataroom.DataRoomService;
import fav.FavoData;
import fav.FavoDataService;

/**
 * Servlet implementation class DataRoomDetail
 */
@WebServlet("/dataroom/detail")
public class DataRoomDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataRoomDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");

		DataRoomService dservice = new DataRoomService();
		DataRoom dr = dservice.getData(num);

		FavoDataService fservice = new FavoDataService();
		FavoData fd = fservice.getFavoData(num, id);
		
		int fcnt = fservice.getFcnt(num);
		dr.setFcnt(fcnt);
		
		boolean flag = true;
		if (fd == null) {
			flag = false;
		}

		request.setAttribute("dr", dr);
		request.setAttribute("flag", flag);

		RequestDispatcher dis = request.getRequestDispatcher("/dataroom/detail.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
