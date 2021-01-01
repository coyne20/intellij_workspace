package co.edureka;

import static org.testng.Assert.*;
//import static org.testng.Assert.assertTrue;
//import static org.testng.Assert.assertFalse;

import org.junit.Test;

public class Assert {

    @Test
    public void testAssertion(){
        String str = new String("Edu");
        String str1 = new String("Edu");
        String str2 = null;
        String str3 = "edu";
        String str4 = "edu";
        int val = 5;
        int val1 = 6;

        String[] expectedArray = {"one","two","three"};
        String[] resultArray = {"one","two","three"};
        assertEquals(str, str1);
        //check for true
        assertTrue(val<val1);
        //check for false
        assertFalse(val>val1);
        //check for Not null
        assertNotNull(str1);
        //check for null
        assertNull(str2);
        //check if the reference is the same object
        assertSame(str3, str4);
        //not same
        assertNotSame(str, str1);
        //assertArrayEquals(expectedArray,resultArray);
    }


}
