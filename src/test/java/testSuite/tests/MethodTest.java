package testSuite.tests;

import model.Method;
import model.Note;
import model.Parameter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A Java class that tests the Method class.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class MethodTest {

    Method method = new Method("foo","String");

    @Test
    public void testMethodNameAndReturnType(){
        Assertions.assertEquals("foo",method.getMethodName());
        method.setMethodName("bar");
        Assertions.assertEquals("bar",method.getMethodName());
        Assertions.assertEquals("String",method.getReturnType());
        method.setReturnType("int");
        Assertions.assertEquals("int",method.getReturnType());
    }

    @Test
    public void testNote(){
        Assertions.assertFalse(method.hasNote());
        method.setNote(new Note("yeehaw"));
        Assertions.assertTrue(method.hasNote());
        Assertions.assertEquals("Method: String foo\nWith Note with body: yeehaw",method.toString());
    }

    @Test
    public void testParameters(){
        Assertions.assertFalse(method.hasParameters());
        Assertions.assertEquals(0,method.parameterCount());
        Assertions.assertEquals("Method: String foo",method.toString());

        Parameter p = new Parameter("input","boolean");
        method.addParameter(p);
        method.addParameter("String","source");
        Assertions.assertTrue(method.hasParameters());
        Assertions.assertEquals(2,method.parameterCount());
        Assertions.assertEquals("Method: String foo\n" +
                "with parameters:\nboolean input\n" +
                "String source",method.toString());

        method.removeParameter("input","boolean");
        Assertions.assertTrue(method.hasParameters());
        Assertions.assertEquals(1,method.parameterCount());
        Assertions.assertEquals("Method: String foo\n" +
                "with parameters:\nString source",method.toString());
    }

}
