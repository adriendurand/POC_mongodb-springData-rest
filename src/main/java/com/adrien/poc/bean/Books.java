package com.adrien.poc.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;

public class Books {

	@Id
	private long id;
	private String title;
	private String author;
	private int nbPages;

	public Books() {
	}

	public Books(long id, String title, String author, int nbPages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.nbPages = nbPages;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
