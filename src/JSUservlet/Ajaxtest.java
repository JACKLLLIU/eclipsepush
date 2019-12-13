package JSUservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Msg;


@WebServlet("/Ajaxtest")
public class Ajaxtest extends HttpServlet {
       
    public Ajaxtest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				System.out.println("123");
				if("admin".equals(username)&&"admin".equals(password)){
					
					Msg msg=new Msg();
					msg.setCode(200);
					msg.setMsg("登录成功");
					msg.setUrl("https://github.com/JACKLLLIU");
					
					String json=new ObjectMapper().writeValueAsString(msg);
					response.getWriter().write(json);
				}else{
					Msg msg=new Msg();
					msg.setCode(999);
					msg.setMsg("账号或者密码出错");
					
					String json=new ObjectMapper().writeValueAsString(msg);
					response.getWriter().write(json);
				
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
