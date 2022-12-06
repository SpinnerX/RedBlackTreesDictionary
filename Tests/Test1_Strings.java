package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import RedBlackTrees.RedBlackTrees;

public class Test1_Strings {
    RedBlackTrees rbt;

    @Before
    public void setup(){
        rbt = new RedBlackTrees();
        rbt.add("D");
        rbt.add("B");
        rbt.add("A");
        rbt.add("C");
        rbt.add("F");
        rbt.add("E");
        rbt.add("H");
        rbt.add("G");
        rbt.add("I");
        rbt.add("J");
    }

    @Test
    public void testPrint(){
        System.out.println("\nSetting up Red Black Tree");
        rbt.print();
        System.out.println("\n");
    }

    @Test
    public void test1(){

        // assertEquals("J", rbt.contains("J").key);

        assertEquals(true, rbt.contains("J"));

        rbt.preOrderVisit("Visit 2");
        assertEquals("DBACFEHGIJ", rbt.getResults());
    }

    @Test
    public void test2(){
        String str=     "Color: 1, Key:D Parent: \n"+
                        "Color: 1, Key:B Parent: D\n"+
                        "Color: 1, Key:A Parent: B\n"+
                        "Color: 1, Key:C Parent: B\n"+
                        "Color: 1, Key:F Parent: D\n"+
                        "Color: 1, Key:E Parent: F\n"+
                        "Color: 0, Key:H Parent: F\n"+
                        "Color: 1, Key:G Parent: H\n"+
                        "Color: 1, Key:I Parent: H\n"+
                        "Color: 0, Key:J Parent: I\n";
        rbt.preOrderVisit("Visit 1");
        String stringDetails = rbt.getResults();

        System.out.println("\nExpected:\n" + str + "\n");
        System.out.println("\nActual:\n" + stringDetails + "\n");
        assertEquals(str, stringDetails);
    }

    @Test
    public void testContains(){
        rbt.add("D");
        rbt.add("B");
        rbt.add("A");
        rbt.add("C");
        rbt.add("F");
        rbt.add("E");
        rbt.add("H");
        rbt.add("G");
        rbt.add("I");
        rbt.add("J");

        assertEquals(true, rbt.contains("D"));
        assertEquals(true, rbt.contains("B"));
        assertEquals(true, rbt.contains("A"));
        assertEquals(true, rbt.contains("C"));
        assertEquals(true, rbt.contains("F"));
        assertEquals(true, rbt.contains("E"));
        assertEquals(true, rbt.contains("H"));
        assertEquals(true, rbt.contains("G"));
        assertEquals(true, rbt.contains("I"));
        assertEquals(true, rbt.contains("J"));

    }
}
