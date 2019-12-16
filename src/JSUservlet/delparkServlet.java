package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParklotDao;

@WebServlet("/delparkServlet")
public class delparkServlet extends HttpServlet {
       
    public delparkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id==""||id==null) {
			return;
		}
		ParklotDao parklotDao = new ParklotDao();
		boolean flag = parklotDao.delete(Integer.parseInt(id));
		if(flag) {
			response.getWriter().print("删除成功");
		}else {
			response.getWriter().print("删除失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
