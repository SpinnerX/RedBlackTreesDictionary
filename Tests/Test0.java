package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import RedBlackTrees.RedBlackTrees;

public class Test0 {
    RedBlackTrees rbt0;
    RedBlackTrees rbt1;
    RedBlackTrees rbt2;

    public void Load(RedBlackTrees rbt){
        String filename = "http://www.math.sjsu.edu/~foster/dictionary.txt";
        try {
            URL dic = new URL(filename);
            Scanner s = new Scanner(dic.openStream());
            rbt.add(s.next()); //adds the first line
            while (s.hasNextLine()) {
                // dict.add(s.nextLine());//adds all the rest of the lines
				String str = s.nextLine().trim();
				rbt.add(str);
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int Verify(RedBlackTrees rbt){
        int count = 0;
        String filename = "http://www.math.sjsu.edu/~foster/dictionary.txt";
        try {
            URL dic = new URL(filename);
            Scanner s = new Scanner(dic.openStream());
            while (s.hasNextLine()) {
                // dict.add(s.nextLine());//adds all the rest of the lines
				String str = s.nextLine().trim();
				if(!rbt.contains(str)) count++;
            }
            s.close();
        }
        catch (IOException ex) { ex.printStackTrace(); }

        return count;
    }

    @Before
    public void setup(){
        rbt0 = new RedBlackTrees();

        rbt1 = new RedBlackTrees();
        
        rbt1.add("D");
        rbt1.add("B");
        rbt1.add("A");
        rbt1.add("C");
        rbt1.add("F");
        rbt1.add("E");
        rbt1.add("H");
        rbt1.add("G");
        rbt1.add("I");
        rbt1.add("J");

        rbt2 = new RedBlackTrees();


        Load(rbt2);
    }


    @Test
    public void testAdd(){
        // Using rbt0 to test if insertion and contains are working before moving forward 
        rbt0.add("C");
        rbt0.add("A");
        rbt0.add("D");

        assertTrue(rbt0.contains("C"));
        assertTrue(rbt0.contains("A"));

        assertFalse(rbt0.contains("K")); // should return false. ERROR CHECKING
        assertFalse(rbt0.contains("Z"));

        rbt0.add("Z");

        assertTrue(rbt0.contains("Z"));
    }

    @Test
    public void testContains(){
        assertTrue(rbt1.contains("D"));
        assertTrue(rbt1.contains("B"));
        assertTrue(rbt1.contains("A"));
        assertTrue(rbt1.contains("C"));
        assertTrue(rbt1.contains("F"));
        assertTrue(rbt1.contains("E"));
        assertTrue(rbt1.contains("H"));
        assertTrue(rbt1.contains("G"));
        assertTrue(rbt1.contains("I"));
        assertTrue(rbt1.contains("J"));
    }
    
    @Test
    public void testAddContains(){
        // Testing by checking if all the words in the dictionary is in the red black tree after loading.
        int count = Verify(rbt2);

        int expected = 0;

        assertEquals(expected, count); // Should be 0 == 0 = true.
    }
}
