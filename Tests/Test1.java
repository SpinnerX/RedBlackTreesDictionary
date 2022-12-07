package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import RedBlackTrees.RedBlackTrees;

public class Test1 {
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
    public void test1(){
        assertEquals("D", rbt.containsNode("D").key);
        assertTrue(rbt.contains("J"));

        rbt.preOrderVisit("Visit 2"); // "Visit 1 = calls a diff visit func, and so does visit 2. (Just for testing purposes."
        assertEquals("DBACFEHGIJ", rbt.getString());
    }

    @Test
    public void testColors(){
        // 0 - RED, 1 - BLACK
        //Testing coloring and black.
        assertEquals(0, rbt.containsNode("J").color); // J is the color red. This is because even when we insert we compare the asci codes and check if the next leaves that node is red before recoloring.
        assertEquals("RED", rbt.containsNode("J").colorLabel());

        assertEquals(1, rbt.containsNode("D").color); // D is color black because this is one of the leaves.
        assertEquals("BLACK", rbt.containsNode("D").colorLabel());

        assertEquals(0, rbt.containsNode("H").color);
        assertEquals("RED", rbt.containsNode("H").colorLabel());

    }


    @Test
    public void test2(){
        String str=     "Color: 1, Key:D Parent: \n" +
                        "Color: 1, Key:B Parent: D\n"+
                        "Color: 1, Key:A Parent: B\n"+
                        "Color: 1, Key:C Parent: B\n"+
                        "Color: 1, Key:F Parent: D\n"+
                        "Color: 1, Key:E Parent: F\n"+
                        "Color: 0, Key:H Parent: F\n"+
                        "Color: 1, Key:G Parent: H\n"+
                        "Color: 1, Key:I Parent: H\n"+
                        "Color: 0, Key:J Parent: I\n";
        
        // preorder the red and black tree.
        rbt.preOrderVisit("Visit 1");

        // 
        String stringDetails = rbt.getString();

        System.out.println("\nExpected:\n" + str + "\n");
        System.out.println("\nActual:\n" + stringDetails + "\n");
        assertEquals(str, stringDetails);
    }
}
