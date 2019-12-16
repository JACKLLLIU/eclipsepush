package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParklotDao;

@WebServlet("/subscribeServlet")
public class subscribeServlet extends HttpServlet {
       
    public subscribeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rowid = request.getParameter("rowid");
		String userid = request.getParameter("userid");
		ParklotDao parklotDao = null;
		if(rowid==""||userid=="") {
			return;
		}
		parklotDao = new ParklotDao();
		boolean flag = parklotDao.subscribe(Integer.parseInt(rowid), Integer.parseInt(userid));
		if(flag) {
			response.getWriter().print("更新成功！");
		}else {
			response.getWriter().print("更新失败！");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
