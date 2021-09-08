package com.jdbcDemoo;

import java.sql.*;

public class GYMMember {
	String name;
	double heightInCm;
	double weightInKG;
	Date joiningDate;
	Date endingDate;
	int feesPaid;
	
	public GYMMember(String name, double heightInCm, double weightInKG, Date joiningDate, Date endingDate,
			int feesPaid) {
		super();
		this.name = name;
		this.heightInCm = heightInCm;
		this.weightInKG = weightInKG;
		this.joiningDate = joiningDate;
		this.endingDate = endingDate;
		this.feesPaid = feesPaid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeightInCm() {
		return heightInCm;
	}
	public void setHeightInCm(double heightInCm) {
		this.heightInCm = heightInCm;
	}
	public double getWeightInKG() {
		return weightInKG;
	}
	public void setWeightInKG(double weightInKG) {
		this.weightInKG = weightInKG;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public int getFeesPaid() {
		return feesPaid;
	}
	public void setFeesPaid(int feesPaid) {
		this.feesPaid = feesPaid;
	}
}
