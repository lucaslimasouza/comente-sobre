package br.com.comentesobre.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Subject {

	private String name;
	@OneToMany
	private List<Comment> comments;
	
	
	public Subject(String name) {
		this.name = name;
		comments = new ArrayList<Comment>();
	}

	public String getName() {
		return name;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComment(Comment comment) {
		comments.add(comment);
	}

}
