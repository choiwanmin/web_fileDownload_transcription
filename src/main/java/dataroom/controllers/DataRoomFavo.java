package dataroom.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fav.FavoData;
import fav.FavoDataService;

/**
 * Servlet implementation class DataRoomFavo
 */
@WebServlet("/dataroom/favo")
public class DataRoomFavo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataRoomFavo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String type = request.getParameter("type");

		FavoDataService service = new FavoDataService();
		if (type.equals("1")) {
			service.addFavo(new FavoData(0, num, id));
		} else {
			service.delFavo(new FavoData(0, num, id));
		}
		response.sendRedirect(request.getContextPath() + "/dataroom/detail?num=" + num + "&id=" + id);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
