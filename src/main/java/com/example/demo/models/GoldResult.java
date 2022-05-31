package com.example.demo.models;


public class GoldResult {
	private String message;
	private int goldProcessed;
	
	public GoldResult(String message, int goldProcessed) {
		this.message = message;
		this.goldProcessed = goldProcessed;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getGoldProcessed() {
		return goldProcessed;
	}
	public void setGoldProcessed(int goldProcessed) {
		this.goldProcessed = goldProcessed;
	}
	
}
