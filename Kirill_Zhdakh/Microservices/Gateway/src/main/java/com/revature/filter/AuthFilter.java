package com.revature.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthFilter extends ZuulFilter {
	
	private static Logger log = Logger.getLogger(AuthFilter.class);

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		String auth = request.getHeader("Authorization");
		if(auth!=null && auth.equals("correct-auth")) {
			log.info("authorization present");
		} else {
			rc.setResponseBody("not authenticated!");
			log.info("authorization not present");
			rc.setSendZuulResponse(false);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
