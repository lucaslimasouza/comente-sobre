package br.com.comentesobre.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.comentesobre.dao.SubjectDAO;
import br.com.comentesobre.model.Comment;
import br.com.comentesobre.model.Subject;

@Resource
public class SubjectsController {

	private final Result result;
	private final SubjectDAO subjectDAO;

	public SubjectsController(Result result, SubjectDAO subjectDAO) {
		this.result = result;
		this.subjectDAO = subjectDAO;
	}

	@Get 
	@Path("/")
	public void form() {
	}

	@Post
	@Path("/subjects")
	public void add(Subject subject) {
		subjectDAO.save(subject);
	}

	@Get
	@Path("/subjects")
	public List<Comment> list() {
		return (List<Comment>) subjectDAO.listAllComments();
	}

	@Get
	@Path("/subjects/{subject.id}")
	public Subject show(Subject subject) {
		return (Subject) subjectDAO.getOneSubject();
	}

}
