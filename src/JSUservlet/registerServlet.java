package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.LoginDao;
import test.Message;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	public registerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao loginDao = new LoginDao();
		boolean flag = loginDao.addUser(username, password);
		if (flag) {
			String json = new ObjectMapper().writeValueAsString(Message.success());
			response.getWriter().write(json);
		} else {
			String json = new ObjectMapper().writeValueAsString(Message.fail());
			response.getWriter().write(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
