package com.revature.sync;

public class StringTestRunnable implements Runnable {
	
	StringBuilder sbuild = new StringBuilder();
	StringBuffer sbuffer = new StringBuffer();
	char c;
	
	public StringTestRunnable() {
		super();
	}
	
	public StringTestRunnable(StringBuilder sbuild, StringBuffer sbuffer, char c) {
		this.sbuffer = sbuffer;
		this.sbuild = sbuild;
		this.c = c;
	}

	@Override
	public void run() {
		for(int i=0; i<50;i++) {
			sbuild = sbuild.append(c);
			sbuffer = sbuffer.append(c);
		}
		
	}

}
