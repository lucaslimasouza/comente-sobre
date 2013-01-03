package br.com.comentesobre.test.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.comentesobre.controller.SubjectsController;
import br.com.comentesobre.dao.SubjectDAO;
import br.com.comentesobre.model.Comment;
import br.com.comentesobre.model.Subject;
import junit.framework.TestCase;

public class SubjectsControllerTest extends TestCase {
	
	private Result result;
	@Mock
	private SubjectDAO subjectDAO;
	@Mock
	private Subject subject;
	private SubjectsController controller;

	public void testAddAnySubject(){
		controller.add(subject);
		
		verify(subjectDAO, times(1)).save(subject);
	}
	
	public void testGetListsOfSubjects(){
		List<Subject> subjects = buildListOfComments();
		Mockito.when(subjectDAO.listAllComments()).thenReturn(subjects);
		
		List<Comment> subjectsReturned = controller.list();
		
		assertEquals(subjects.size(), subjectsReturned.size());
		assertTrue(subjects.containsAll(subjectsReturned));
		verify(subjectDAO, times(1)).listAllComments();
	}
	
	public void testGetOnlyOneSubject(){
		Subject subject = mock(Subject.class);
		Mockito.when(subject.getName()).thenReturn("metedos ageis");
		Mockito.when(subjectDAO.getOneSubject()).thenReturn(subject);
		
		Subject subjectReturned  = controller.show(subject);
		
		assertEquals(subject.getName(), subjectReturned.getName());
		verify(subjectDAO, times(1)).getOneSubject();
	}
	

	private List<Subject> buildListOfComments() {
		List<Subject> comments = new ArrayList<Subject>();
		comments.add(mock(Subject.class));
		comments.add(mock(Subject.class));
		return comments;
	}
	
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		controller = new SubjectsController(result,subjectDAO);
		this.result = new MockResult();
	}
	
}
