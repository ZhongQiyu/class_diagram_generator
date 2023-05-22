package testSuite.tests;

import model.ClassInfo;
import model.Inheritance;
import model.Stereotype;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * The test class for the inheritance model.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class InheritanceTest {

    private ClassInfo class1 = new ClassInfo("class1",0,0);
    private ClassInfo class2 = new ClassInfo("class2",200,0);
    private Inheritance inheritance1 = new Inheritance(class1, class2);

    @Before
    public void setup() {

    }

    @Test
    public void testGetOrigin() {
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)",
                inheritance1.getOrigin().toString());
    }

    @Test
    public void testSetOrigin() {
        inheritance1.setOrigin(new ClassInfo("class4",200,200));
        Assertions.assertEquals("A class called class4 located at coordinate (200.0, 200.0)",
                inheritance1.getOrigin().toString());

    }

    @Test
    public void testGetDestination() {
        Assertions.assertEquals("A class called class2 located at coordinate (200.0, 0.0)",
                inheritance1.getDestination().toString());
    }

    @Test
    public void testSetDestination() {
        inheritance1.setDestination(new ClassInfo("class4",200,200));
        Assertions.assertEquals("A class called class4 located at coordinate (200.0, 200.0)",
                inheritance1.getDestination().toString());
    }

    @Test
    public void testHasStereotype() {
        Assertions.assertFalse(inheritance1.hasStereotype());
        inheritance1.setRelation(new Stereotype("this is a stereotype"));
        Assertions.assertTrue(inheritance1.hasStereotype());
    }

    @Test
    public void testSetStereotype() {
        Assertions.assertEquals("An inheritance relationship where class1 inherits class2",
                inheritance1.toString());
        inheritance1.setRelation(new Stereotype("Stereotype"));
        Assertions.assertEquals("An inheritance relationship where class1 inherits class2 with stereotype <<Stereotype>>",
                inheritance1.toString());
    }

    @Test
    public void testGetStereotype() {
        Assertions.assertNull(inheritance1.getRelation());
        inheritance1.setRelation(new Stereotype("Stereotype"));
        Assertions.assertEquals("<<Stereotype>>",inheritance1.getRelation().toString());
    }

}
