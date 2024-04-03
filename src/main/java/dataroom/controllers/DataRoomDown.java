package dataroom.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataroom.DataRoomService;

/**
 * Servlet implementation class DataRoomDown
 */
@WebServlet("/dataroom/down")
public class DataRoomDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataRoomDown() {
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

		String fname = request.getParameter("fname");
		File f = new File(DataRoomService.path + fname);
		FileInputStream fi = new FileInputStream(DataRoomService.path + fname);

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fname);

		OutputStream os = response.getOutputStream();

		int len;
		byte[] b = new byte[(int) f.length()];

		while ((len = fi.read(b)) > 0) {
			os.write(b, 0, len);
		}
		os.flush();

		os.close();
		fi.close();

		int num = Integer.parseInt(request.getParameter("num"));
		DataRoomService service = new DataRoomService();
		service.editCnt(num);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
