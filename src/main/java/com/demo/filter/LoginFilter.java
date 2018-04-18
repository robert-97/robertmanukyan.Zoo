package com.demo.filter;

import com.demo.cookieFinder.CookieFinder;

import java.io.IOException;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by robert.manukyan on 3/16/2018.
 */

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String servletPath = httpRequest.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath + ", URL =" + httpRequest.getRequestURL());

        if (httpRequest.getRequestURL().toString().equals("http://localhost:8080/welcome.jsp") && CookieFinder.getCookie(request, "temp") == null) {
//            httpRequest.getRequestDispatcher("/").forward(request,response);
            httpResponse.sendRedirect("/");
            return;
        }
        chain.doFilter(request, response);
    }
}
