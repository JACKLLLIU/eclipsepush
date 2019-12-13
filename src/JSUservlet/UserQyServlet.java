package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.users;
import dao.UserDao;
import test.Message;

@WebServlet("/UserQyServlet")
public class UserQyServlet extends HttpServlet {
	public UserQyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		users user = null;
		if(id!=null) {
			UserDao userDao = new UserDao();
			user = new users();
			user = userDao.queryUser(Integer.parseInt(id));
			String json = new ObjectMapper()
					.writeValueAsString(Message.success().add("user", user));
			response.getWriter().write(json);
		}else {
			String json = new ObjectMapper()
					.writeValueAsString(Message.fail());
			response.getWriter().write(json);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
