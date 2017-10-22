package com.zyq.springtest.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
public class AdminFilter implements Filter {

    private FilterConfig config;


    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();

        String noLoginPaths = config.getInitParameter("noLoginPaths");

        if (noLoginPaths != null) {
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i] == null || "".equals(strArray[i])) continue;
                if (request.getRequestURI().indexOf(strArray[i]) != -1) {
                    arg2.doFilter(arg0, arg1);
                    return;
                }
            }
        }
        if (session.getAttribute("user") != null) {
            arg2.doFilter(arg0, arg1);
        } else {
            response.sendRedirect("accessdeny");
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
        config = arg0;
    }

}


