package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParklotDao;

@WebServlet("/addparkServlet")
public class addparkServlet extends HttpServlet {
       
    public addparkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("location");
		String status = request.getParameter("status");
		if((location==""||location==null)&&(status==""||status==null)) {
			return;
		}
		ParklotDao parklotDao = new ParklotDao();
		boolean flag = parklotDao.add(location, Integer.parseInt(status));
		if(flag) {
			response.getWriter().print("添加成功！！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
