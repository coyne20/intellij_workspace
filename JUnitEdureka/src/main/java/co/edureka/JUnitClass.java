package co.edureka;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class JUnitClass {

    @Test
    public void setUp(){
        String str = "This is my first JUnit program";
        assertEquals("This is my first JUnit program",str);
    }

}
