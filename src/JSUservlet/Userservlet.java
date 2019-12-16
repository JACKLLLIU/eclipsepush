package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.UserDao;
import test.Message;

@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
    public Userservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String licenseplate = request.getParameter("licenseplate");
		String selector = request.getParameter("selector");
		String age = request.getParameter("age");
		String phone= request.getParameter("phone");
		String sex = "";
		if(id==null||id=="") {
			return;
		}
		if(0==Integer.parseInt(selector)) {
			sex="男";
		}else if(1==Integer.parseInt(selector)){
			sex="女";
		}
		UserDao userDao = new UserDao();
		boolean flag = userDao.updateUser(name, licenseplate, age, sex, phone, id);
		if(flag) {
			String json = new ObjectMapper().writeValueAsString(Message.success());
			response.getWriter().write(json);
		}else {
			String json = new ObjectMapper().writeValueAsString(Message.fail());
			response.getWriter().write(json);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
