package com.zyq.springtest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String charSet;


	public void init(FilterConfig filterConfig) throws ServletException {
		this.charSet = filterConfig.getInitParameter("charSet");

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		servletRequest.setCharacterEncoding(charSet);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {

	}
}
