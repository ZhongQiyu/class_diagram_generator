package testSuite.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import model.Coordinate;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * A Java class that aims for testing the coordinate.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
@RunWith(JUnit4.class)
public class CoordinateTest {

    private Coordinate coordinate1;

    @Before
    public void setup() {
        coordinate1 = new Coordinate(0, 0);
    }

    @Test
    public void testConstructor() {
        coordinate1 = new Coordinate(1, 1);
        Assertions.assertEquals("(1.0, 1.0)", coordinate1.toString());
        coordinate1 = new Coordinate(-10, 10);
        Assertions.assertEquals("(-10.0, 10.0)", coordinate1.toString());
    }

    @Test
    public void testGetX() {
        int x = 10;
        int y = 10;
        coordinate1 = new Coordinate(x, y);
        Assertions.assertEquals(10, coordinate1.getX());
        Assertions.assertEquals("(10.0, 10.0)", coordinate1.toString());
    }

    @Test
    public void testSetX() {
        coordinate1 = new Coordinate(1, 1);
        coordinate1.setX(10);
        Assertions.assertEquals("(10.0, 1.0)", coordinate1.toString());
    }

    @Test
    public void testGetY() {
        coordinate1 = new Coordinate(100, -1);
        Assertions.assertEquals(-1, coordinate1.getY());
        Assertions.assertEquals("(100.0, -1.0)", coordinate1.toString());
    }

    @Test
    public void testSetY() {
        coordinate1 = new Coordinate(-1, -1);
        coordinate1.setY(-100);
        Assertions.assertEquals("(-1.0, -100.0)", coordinate1.toString());
    }

}
