package com.toyproject.board;


public class BoardDTO {
	private String title;
	private String contents;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		System.out.println("인코딩 Test");
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
