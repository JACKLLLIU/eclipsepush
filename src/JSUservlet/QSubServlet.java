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

import bean.subscribe;
import dao.SubscribeDao;


@WebServlet("/QSubServlet")
public class QSubServlet extends HttpServlet {
       
    public QSubServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id==""||id==null) {
			return;
		}
		SubscribeDao subscribedao = new SubscribeDao();
		List<subscribe> list = subscribedao.QueryByid(Integer.parseInt(id));
		request.setAttribute("info", list);
		String json = new ObjectMapper().writeValueAsString(list);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
