package br.com.comentesobre.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	private String text;
	private String owner;
	@ManyToOne
	private Subject subject;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setOwner(String owner) {
		this.owner = owner;
		
	}

	public String getOwner() {
		return owner;
	}

}
