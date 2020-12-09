package com.revature.model;

import java.io.Serializable;

public enum RS implements Serializable{
	REQUEST_CREATED         (1),
	AWAIT_SUPER_APPROVAL    (2),
	ADD_INFO_REQUESTED      (3),
	ADD_INFO_SUBMITTED      (4),
	AWAIT_DPT_HEAD_APPROVAL (5),
	AWAIT_BENCO_APPROVAL    (6),
	AWAIT_EMPLOYEE_APPROVAL (7),
	AWAIT_GRADE             (8),
	AWAIT_PRESENTATION      (9),
	AWAIT_GRADE_CONFIRM     (10),
	AWAIT_PRESENT_CONFIRM   (11),
	REQUEST_ESCALATED       (12),
	REQUEST_REJECTED        (13),
	APPROVED_AND_AWARDED    (14);
	
	private final int statusCode;
	
	RS(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return this.statusCode;
	}
	
	public static RS valueOfStatusCode(int status) {
		for (RS rs : values()) {
			if (rs.getStatusCode() == status) {
				return rs;
			}
		}
		return null;
	}
	
}