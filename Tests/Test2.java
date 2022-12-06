package Tests;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import RedBlackTrees.RedBlackTrees;

public class Test2 {

    RedBlackTrees rbt;

    @Before
    public void setup(){
        rbt = new RedBlackTrees();
    }

    @Test
    public void timeRedBlackTrees2(){
        ArrayList<String> dict = new ArrayList<String>();
		int count = 0;
        long start=0, end=0;
        try {
			String urlName = "http://www.math.sjsu.edu/~foster/dictionary.txt";
            URL dic = new URL(urlName);
            Scanner s = new Scanner(dic.openStream());
            dict.add(s.next());//adds the first line
            start = System.nanoTime();

            while (s.hasNextLine()) {
				String str = s.nextLine().trim();

				String upperStr = str.toUpperCase();
				if(!rbt.contains(upperStr)) count++;
            }

            end = System.nanoTime();
            s.close();
        }
		catch (IOException ex) { ex.printStackTrace(); }

		if(count == 0) System.out.println("All Tests Passed!");
		else System.out.println("Total Count: " + count);
        float current = end - start;

        System.out.println("Current Time: " + current/10000);
    }
    
}
