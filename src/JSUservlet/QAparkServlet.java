package JSUservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import bean.parkinglot;
import dao.ParklotDao;
import test.Message;

@WebServlet("/QAparkServlet")
public class QAparkServlet extends HttpServlet {

	public QAparkServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//得到客户端传递的页码和每页记录数，并转换成int类型
		//int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		//int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		ParklotDao parklotDao = new ParklotDao();
		List<parkinglot> list = parklotDao.qAllParklot();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", list.size());
		String json1 = new ObjectMapper().writeValueAsString(map);
		response.getWriter().write(json1);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
