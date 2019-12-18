package JSUservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.occupy;
import bean.subscribe;
import dao.OccupyDao;

@WebServlet("/QoccupyServlet")
public class QoccupyServlet extends HttpServlet {
       
    public QoccupyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<occupy> list = OccupyDao.queryOccupyById(Integer.parseInt(id));
		request.setAttribute("info", list);
		request.getRequestDispatcher("/html/occupy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
