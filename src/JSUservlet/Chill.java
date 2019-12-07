package JSUservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import bean.Users;

@WebServlet("/Chill")
public class Chill extends HttpServlet {
	static List<Users> userList = new ArrayList<Users>();
	static {
		userList.add(new Users("刘备", "123"));
		userList.add(new Users("关羽", "123"));
		userList.add(new Users("刘备", "321"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean flag = false;
		for (Users user : userList) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				flag = true;
			}

		}
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			Cookie cookie = new Cookie("jsession", session.getId());
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
			response.sendRedirect("/WebTest/index.jsp");
		} else {
			request.setAttribute("message", "用户名密码不正确！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
