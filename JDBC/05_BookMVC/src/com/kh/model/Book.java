package com.kh.model;

public class Book {

	private String title;
	private String author;
	private String name;
	private String password;
	private String id;

	public Book() {
	}

	public Book(String title, String author, String name, String password, String id) {
		this.title = title;
		this.author = author;
		this.name = name;
		this.password = password;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", name=" + name + ", password=" + password + ", id="
				+ id + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
