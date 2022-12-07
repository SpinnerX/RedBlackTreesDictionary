package Tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import RedBlackTrees.RedBlackTrees;
import RedBlackTrees.Loading;


public class Test2 {
    RedBlackTrees rbt;
    Loading load;

    @Before
    public void setup(){
        rbt = new RedBlackTrees();
        
        // Adding into rbt.

        // Load(rbt);
        // String filename = "https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt";
        // "https://raw.githubusercontent.com/schmij03/RedBlackTreesDictionary/main/poem.txt
        String filename = "https://raw.githubusercontent.com/schmij03/RedBlackTreesDictionary/main/poem.txt";
        load.LoadPoem(rbt, filename);
    }

    @Test
    public void testContains(){
        int count = load.Verify(rbt);

        assertEquals(0, count);
    }



}
