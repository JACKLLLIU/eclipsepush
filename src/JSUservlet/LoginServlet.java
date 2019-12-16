package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.admin;
import bean.users;
import dao.LoginDao;
import test.Message;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String selector = request.getParameter("selector");
		admin admin = null;
		users user = null;
		if (username != "" || password != "") {
			LoginDao loginDao = new LoginDao();
			if (0 == Integer.valueOf(selector)) {
				admin = loginDao.queryAdmin(username, password);
			}
			if(1 == Integer.valueOf(selector)) {
				user = loginDao.queryUsers(username, password);
			}
			if(admin==null&&user==null) {
				return;
			}
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				Cookie cookie = new Cookie("jsession", session.getId());
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
				// response.sendRedirect();
				Message.success().toString();
				String json = new ObjectMapper()
						.writeValueAsString(Message.success().add("url", "fristshow.jsp"));
				response.getWriter().write(json);
			}
			if (admin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				Cookie cookie = new Cookie("jsession", session.getId());
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
				// response.sendRedirect();
				Message.success().toString();
				String json = new ObjectMapper()
						.writeValueAsString(Message.success().add("url", "fristshow.jsp"));
				response.getWriter().write(json);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
