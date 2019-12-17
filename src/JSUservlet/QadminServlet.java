package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.admin;
import dao.LoginDao;
import test.Message;

@WebServlet("/QadminServlet")
public class QadminServlet extends HttpServlet {
       
    public QadminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("adminid");
		if(adminid==null||adminid=="") {
			return;
		}
		LoginDao loginDao = new LoginDao();
		admin admin = loginDao.queryAdminById(Integer.parseInt(adminid));
		String json = new ObjectMapper().writeValueAsString(admin);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
