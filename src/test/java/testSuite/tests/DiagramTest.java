package testSuite.tests;

import model.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * The Java class that tests for the Diagram class.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class DiagramTest {

    Diagram diagram = new Diagram();
    ClassInfo class1 = new ClassInfo("class1",0,0);
    ClassInfo class2 = new ClassInfo("class2",200,0);
    Instance instance = new Instance(class1, class2);
    Inheritance inheritance = new Inheritance(class2, class1);

    @Test
    public void testConstructor() {
        Assertions.assertEquals("A diagram containing:\nnothing",diagram.toString());

        ArrayList<ClassInfo> classes = new ArrayList<>();
        classes.add(class1);
        classes.add(class2);

        ArrayList<Relationship> relationships = new ArrayList<>();
        relationships.add(instance);
        relationships.add(inheritance);

        Diagram diagram1 = new Diagram(classes, relationships);
        Assertions.assertEquals("A diagram containing:\nClasses:\n" +
                "A class called class1 located at coordinate (0.0, 0.0)\n" +
                "A class called class2 located at coordinate (200.0, 0.0)\n" +
                "Relationships:\n" +
                "An instance relationship where class1 is an instance of class2\n" +
                "An inheritance relationship where class2 inherits class1",diagram1.toString());
    }

    @Test
    public void testGetClasses() {
        ClassInfo iceCreamClass = new ClassInfo("IceCream",0,0);
        ArrayList<ClassInfo> classInfos = new ArrayList<>();
        classInfos.add(iceCreamClass);
        diagram.addClass(iceCreamClass);
        Assertions.assertEquals(classInfos.toString(),diagram.getClasses().toString());

        ClassInfo cottonCandyClass = new ClassInfo("CottonCandy",200,0);
        classInfos.add(cottonCandyClass);
        diagram.addClass(cottonCandyClass);
        Assertions.assertEquals(classInfos.toString(),diagram.getClasses().toString());
    }

    @Test
    public void testGetRelationships() {
        Instance instance = new Instance(class1, class2);
        ArrayList<Relationship> relationships = new ArrayList<>();
        relationships.add(instance);
        diagram.addRelationship(instance);
        Assertions.assertEquals(relationships.toString(),diagram.getRelationships().toString());

        Inheritance inheritance = new Inheritance(class2, class1);
        relationships.add(inheritance);
        diagram.addRelationship(inheritance);
        Assertions.assertEquals(relationships.toString(),diagram.getRelationships().toString());

    }

}
