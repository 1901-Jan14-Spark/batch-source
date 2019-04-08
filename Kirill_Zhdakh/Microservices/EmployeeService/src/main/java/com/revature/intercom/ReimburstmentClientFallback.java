package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Reimburstment;

@Component
public class ReimburstmentClientFallback implements ReimburstmentClient{

	@Override
	public List<Reimburstment> getReimburstmentsByEmployeeId(Integer employeeId) {
		return null;
	}
}
