package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParklotDao;

@WebServlet("/ResetPlServlet")
public class ResetPlServlet extends HttpServlet {
    public ResetPlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id==""||id==null) {
			return;
		}
		ParklotDao parklotDao = new ParklotDao();
		boolean flag =  parklotDao.reset(Integer.parseInt(id));
		if(flag) {
			response.getWriter().print("重置成功！！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
