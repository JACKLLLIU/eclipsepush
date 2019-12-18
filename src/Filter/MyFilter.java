package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.admin;
import bean.users;
//@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        users user = (users)session.getAttribute("user");
        admin admin = (admin)session.getAttribute("admin");
        String uri = request.getRequestURI();
        
        if(user==null&&admin==null){//没有用户和管理员
            //判断用户是否是选择跳到登录界面
            if(uri.endsWith("login.jsp")||uri.endsWith("LoginServlet")){
            	chain.doFilter(req, resp);
            }else{
            	response.sendRedirect(request.getContextPath()+"/html/login.jsp");
            }    
        }else{//有用户
        	chain.doFilter(req, resp);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
