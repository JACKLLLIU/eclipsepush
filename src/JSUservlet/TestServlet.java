package JSUservlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
/*		response.getWriter().append("Served at: ").append(request.getContextPath());
		String gg = getServletContext().getRealPath("/");
		String prjname = getServletContext().getContextPath();
		getServletContext().getResourceAsStream("/");
		HttpSession session = request.getSession();
		session.setAttribute("name", "value");
		session.setMaxInactiveInterval(24*60*60);
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		response.addCookie(cookie);*/
		
		HttpSession session = request.getSession();
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		session.setAttribute("list", list);
		list.add(3);
		
		List list1 = (List) request.getAttribute("list"); 
		for(int i = 0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
