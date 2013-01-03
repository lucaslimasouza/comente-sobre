package br.com.comentesobre.test.model;

import br.com.comentesobre.model.Comment;
import br.com.comentesobre.model.Subject;
import junit.framework.TestCase;

public class CommentTest extends TestCase {
	private Comment comment;
	
	public void testAddText(){
		comment.setText("excelente metodo");
		assertEquals("excelente metodo", comment.getText());
	}
	
	public void testAddOwner(){
		comment.setOwner("example@mail.com");
		assertEquals("example@mail.com", comment.getOwner());
	}
	

	public void setUp(){
		comment = new Comment();
	}
}
