package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Users;

/**
 * Servlet implementation class TestFilter
 */
@WebServlet("/TestFilter")
public class TestFilter extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		response.getWriter().print(name);
		response.getWriter().print(password);
		Users user = new Users();
		user.setUsername(name);
		user.setPassword(password);
		ObjectMapper objectMapper = new ObjectMapper();
		String s = objectMapper.writeValueAsString(user);
		System.out.println(s);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
