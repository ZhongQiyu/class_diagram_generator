package testSuite.tests;

import model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The test class for the ClassInfo representation.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class ClassInfoTest {

    private ClassInfo class1 = new ClassInfo("class1",0,0);

    @Before
    public void setup(){
        class1 = new ClassInfo("class1", new Coordinate(0,0));
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("A class called class1 " +
                "located at coordinate (0.0, 0.0)",class1.toString(), "a class constructed with name class1 and location 0,0 " +
                        "should accurately print");
        ClassInfo class2 = new ClassInfo("class2",new Coordinate(200,200));
        Assertions.assertEquals("A class called class2 located at coordinate (200.0, 200.0)",
                class2.toString());
    }

    @Test
    public void testMovingAndShifting(){
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)",class1.toString());
        class1.shiftPosition(100,0);
        Assertions.assertEquals("A class called class1 located at coordinate (100.0, 0.0)",class1.toString());
        class1.shiftPosition(100,100);
        Assertions.assertEquals("A class called class1 located at coordinate (200.0, 100.0)",class1.toString());
        class1.setPosition(new Coordinate(200,200));
        Assertions.assertEquals("A class called class1 located at coordinate (200.0, 200.0)",class1.toString());
        class1.setPosition(400, 100);
        Assertions.assertEquals("A class called class1 located at coordinate (400.0, 100.0)",class1.toString());
    }

    @Test
    public void testStereotype(){
        class1.setStereotype(new Stereotype("This is a stereotype"));
        Assertions.assertEquals("A class called class1 " +
                "located at coordinate (0.0, 0.0)\nwith stereotype <<This is a stereotype>>",class1.toString(), "giving class1 a stereotype");
        class1.removeStereotype();
        Assertions.assertEquals(
                "A class called class1 located at coordinate (0.0, 0.0)",class1.toString(), "removing stereotype should remove stereotype");
    }

    @Test
    public void testMethods(){
        class1.addMethod(new Method("foo","int"));
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "containing methods:\nMethod: int foo",class1.toString());
        class1.addMethod(new Method("bar","String"));
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "containing methods:\nMethod: int foo\nMethod: String bar",class1.toString());
        class1.removeMethod("bar");
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "containing methods:\nMethod: int foo",class1.toString());
    }

    @Test
    public void testInstanceVariables(){
        class1.addInstanceVariable(new Variable("int","foo"));
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "containing variables:\nint foo",class1.toString());
        class1.addInstanceVariable("String","bar");
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "containing variables:\nint foo\nString bar",class1.toString());
        class1.removeInstanceVariable("int","foo");
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "containing variables:\nString bar",class1.toString());
    }

    @Test
    public void testStereotypes(){
        Assertions.assertFalse(class1.hasStereotype());
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)",class1.toString());
        Stereotype testStereotype = new Stereotype("chicken nuggets");
        class1.setStereotype(testStereotype);
        Assertions.assertTrue(class1.hasStereotype());
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)\n" +
                "with stereotype <<chicken nuggets>>",class1.toString());
        Assertions.assertEquals(testStereotype.toString(),class1.getStereotype().toString());
        class1.removeStereotype();
        Assertions.assertFalse(class1.hasStereotype());
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)",class1.toString());
    }

    @Test
    public void getInfo() {

    }

    @After
    public void tearDown() {
        // we do teardown when the resources are too consuming
    }

}