package com.zoho.dto;

public class Gst {
	private double num1;

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}
	
	public double Total() {
		return (num1 + num1*(0.18));
	}
}
