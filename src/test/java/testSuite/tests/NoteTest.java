package testSuite.tests;

import model.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The Java class that tests for the Note class.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class NoteTest {

    Note note = new Note("this is a note");

    @Test
    public void testConstructor() {
        Assertions.assertEquals("Note with body: this is a note",note.toString());
    }

    @Test
    public void testGetBody(){
        Assertions.assertEquals("this is a note",note.getBody());
    }

    @Test
    public void testSetBody(){
        note.setBody("new body");
        Assertions.assertEquals("Note with body: new body",note.toString());
    }

}
