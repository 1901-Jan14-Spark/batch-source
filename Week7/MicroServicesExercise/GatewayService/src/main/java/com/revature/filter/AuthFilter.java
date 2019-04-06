package com.revature.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		String auth = request.getHeader("Authorization");
		if(auth != null && auth.equals("correct-auth")) {
			System.out.println("authorization present");
		}
		else {
			rc.setResponseBody("not authenticated!");
			System.out.println("authorization not present.");
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