package com.revature.filter;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class LoggingFilter extends ZuulFilter {

	private Logger log = Logger.getLogger(LoggingFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		log.info(request.getMethod()+ " made to "+request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
