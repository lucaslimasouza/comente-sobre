package br.com.comentesobre.test.model;

import static org.mockito.Mockito.mock;
import br.com.comentesobre.model.Comment;
import br.com.comentesobre.model.Subject;
import junit.framework.TestCase;

public class SubjectTest extends TestCase {
	
	private Subject subject;
	
	public void testNewSubject() {
		assertEquals("scrum", subject.getName());
	}
	
	public void testAddComment(){
		Comment comment = mock(Comment.class);
		subject.setComment(comment);
		assertTrue(subject.getComments().contains(comment));
	}
	
	public void setUp(){
		subject = new Subject("scrum");
	}

}
