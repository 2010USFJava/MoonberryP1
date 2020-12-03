package com.revature.model;

public enum Event_Type {
	UNIVERSITY_COURSE 	(0.8),
	SEMINAR				(0.6),
	CERT_PREP_COURSE	(0.75),
	CERT				(1.0),
	TECH_TRAINING		(0.9),
	OTHER				(0.3);
	
	private final double rmbsment_coverage;
	
	Event_Type(double coverage) {
		this.rmbsment_coverage = coverage;
	}
	
	public double getRmbsmentCoverage() {
		return this.rmbsment_coverage;
	}
}
