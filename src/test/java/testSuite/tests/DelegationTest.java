package testSuite.tests;// imports of testing suites


import model.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.Before;

/**
 * The test for the Java class that represents for Delegation.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class DelegationTest {

    private ClassInfo class1 = new ClassInfo("class1",0,0);
    private ClassInfo class2 = new ClassInfo("class2",200,0);
    private ClassInfo class3 = new ClassInfo("class3",200,0);
    private Delegation delegation1 = new Delegation(class1, class2);
    private Delegation delegation2 = new Delegation(class2, class3);

    @Before
    public void setUp() {
        String className = "1";
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<ArrayList<String>> instanceVariables = new ArrayList<ArrayList<String>>();
        Coordinate location = new Coordinate(1, 1);
        Stereotype stereotype = new Stereotype("test1");
        ClassInfo delegator = new ClassInfo(className, location);

        String className2 = "2";
        ArrayList<Method> methods2 = new ArrayList<>();
        ArrayList<ArrayList<String>> instanceVariables2 = new ArrayList<ArrayList<String>>();
        Coordinate location2 = new Coordinate(2, 2);
        Stereotype stereotype2 = new Stereotype("test2");
        ClassInfo delegatee = new ClassInfo(className2, location2);

        String labelName = "testLabel";
        Stereotype label = new Stereotype(labelName);

        String methodName = "testMethod";
        ArrayList<Parameter> parameters = new ArrayList<>();
        String returnType = "testType";
        Note note = new Note("This is a piece of note, which is meaningless.");
        Method operation = new Method(methodName, returnType);

        delegation1 = new Delegation(delegator, delegatee, label, operation);
        delegation2 = new Delegation(delegator, delegatee, label, operation);
    }

    @Test
    public void getOrigin() {
        ClassInfo delegator = delegation1.getOrigin();
        Assertions.assertEquals("A class called class1 located at coordinate (0.0, 0.0)",delegator.toString());
    }

    @Test
    public void getDestination() {
        ClassInfo delegatee = delegation1.getDestination();
        Assertions.assertEquals("A class called class2 located at coordinate (200.0, 0.0)", delegatee.toString());
    }

    @Test
    public void hasStereotype(){
        Assertions.assertFalse(delegation1.hasStereotype());
        delegation1.setRelation(new Stereotype("stereotype"));
        Assertions.assertTrue(delegation1.hasStereotype());
    }

    @Test
    public void getStereotype() {
        Assertions.assertNull(delegation1.getRelation());
        delegation1.setRelation(new Stereotype("stereotype"));
        Assertions.assertEquals("<<stereotype>>",delegation1.getRelation().toString());
    }

    @Test
    public void getOperation() {
        Assertions.assertNull(delegation1.getOperation());
        Method method = new Method("foo","int");
        delegation1.setOperation(method);
        Assertions.assertEquals("Method: int foo",delegation1.getOperation().toString());
    }

    @Test
    public void testToString() {  // naming convention
        Assertions.assertEquals(delegation1.toString(), delegation1.toString(), "The plain input of the delegation should work around in a " +
                     "pretty normal way.");
    }

    @Test
    public void delegate() {
        Assertions.assertNotEquals(
                delegation1.toString(), delegation2.toString(), "It is known for all of us that the two delegations are equal.");

        String className3 = "3";
        ArrayList<Method> methods3 = new ArrayList<>();
        ArrayList<ArrayList<String>> instanceVariables3 = new ArrayList<ArrayList<String>>();
        Coordinate location3 = new Coordinate(3, 3);
        Stereotype stereotype3 = new Stereotype("test3");
        ClassInfo delegator3 = new ClassInfo(className3, location3);

        String className4 = "4";
        ArrayList<Method> methods4 = new ArrayList<>();
        ArrayList<ArrayList<String>> instanceVariables4 = new ArrayList<ArrayList<String>>();
        Coordinate location4 = new Coordinate(4, 4);
        Stereotype stereotype4 = new Stereotype("test4");
        ClassInfo delegatee3 = new ClassInfo(className4, location4);

        String newLabelName = "testLabel2";
        Stereotype newLabel = new Stereotype(newLabelName);

        String methodName = "testMethod2";
        ArrayList<Parameter> parameters = new ArrayList<>();
        String returnType = "testType2";
        Note note = new Note("This is another piece of meaningless note. Java is the BEST language in the world.");
        Method operation3 = new Method(methodName, returnType);

        Delegation delegation3 = new Delegation(delegator3, delegatee3, newLabel, operation3);
        Assertions.assertNotEquals(delegation1.toString(), delegation3.toString(), "After adding a third class, we now know that none of the "
                      + "delegations are gonna be equal. This holds for both of the "
                      + "delegations.");
        Assertions.assertNotEquals(delegation2.toString(), delegation3.toString(), "After adding a third class, we now know that none of the "
                      + "delegations are gonna be equal. This holds for both of the "
                      + "delegations.");
    }

}
