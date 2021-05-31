package com.demo.beans;

public class Word {
	private String title;
	private String colour;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "Word [title=" + title + ", colour=" + colour + ", isClicked=" + status + "]";
	}
	
	
	

}
