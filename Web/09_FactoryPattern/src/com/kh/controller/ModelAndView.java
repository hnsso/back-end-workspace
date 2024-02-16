package com.kh.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;

	public ModelAndView() {}

	public ModelAndView(String path) { // forward 방식일때 사용 !!
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) { // sendRedirect !! 일때 true 값이랑 같이 넘겨보내자
		this.path = path;
		this.isRedirect = isRedirect;
	}

	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
