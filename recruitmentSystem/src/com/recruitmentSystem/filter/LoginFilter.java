package com.recruitmentSystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		
		HttpServletRequest rq=(HttpServletRequest )request;
        int uid= (Integer)rq.getSession().getAttribute("uid");
        if(uid==0 ){
       	 rq.setAttribute("msg", "请登录后访问该页面");
       	 rq.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        // pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
