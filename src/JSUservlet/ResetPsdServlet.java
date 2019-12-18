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

@WebServlet("/ResetPsdServlet")
public class ResetPsdServlet extends HttpServlet {
       
    public ResetPsdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		String psd1 = request.getParameter("psd1");
		String psd2 = request.getParameter("psd2");
		LoginDao dao = new LoginDao();
		boolean flag = dao.queryUser(Integer.parseInt(id), psd1, psd2);
		if(flag) {
			String json = new ObjectMapper()
					.writeValueAsString(Message.success().add("url", "login.jsp"));
			request.getSession().invalidate();//session失效
			response.getWriter().write(json);
			
		}else {
			response.getWriter().print("重置失败");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
