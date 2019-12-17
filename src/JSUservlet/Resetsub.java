package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubscribeDao;

@WebServlet("/Resetsub")
public class Resetsub extends HttpServlet {
       
    public Resetsub() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("location");
		SubscribeDao subscribeDao = new SubscribeDao();
		boolean flag = subscribeDao.cancelSub(location);
		if(flag) {
			response.getWriter().print("操作成功！！");
		}else {
			response.getWriter().print("操作失败！！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
