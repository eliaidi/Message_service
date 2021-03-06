package com.springMVC.Filter;

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

/**
 * Servlet Filter implementation class UserService
 */
@WebFilter("/UserService")
public class UserService implements Filter {

    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest requ=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
			HttpSession session=requ.getSession(true);
			String id=(String) session.getAttribute("id");
			if(id.equals("###")){
				resp.sendRedirect("");//重定向到用户登录注册界面
			}else{
				chain.doFilter(request, response);
			}
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
