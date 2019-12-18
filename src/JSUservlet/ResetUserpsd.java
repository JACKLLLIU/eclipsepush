package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/ResetUserpsd")
public class ResetUserpsd extends HttpServlet {
       
    public ResetUserpsd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao dao = new UserDao();
		boolean flag = dao.Resetpsd(Integer.parseInt(id));
		if(flag) {
			response.getWriter().print("重置成功，重置密码：123456");
		}else {
			response.getWriter().print("重置失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
