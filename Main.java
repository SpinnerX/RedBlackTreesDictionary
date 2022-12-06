import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import RedBlackTrees.RedBlackTrees;


public class Main{

	public static void LoadDictionary(RedBlackTrees rbt) {
        ArrayList<String> dict = new ArrayList<String>();
        try {
            URL dic = new URL("http://www.math.sjsu.edu/~foster/dictionary.txt");
            Scanner s = new Scanner(dic.openStream());
            dict.add(s.next());//adds the first line
            while (s.hasNextLine()) {
                // dict.add(s.nextLine());//adds all the rest of the lines
				String str = s.nextLine().trim();

				String upperStr = str.toUpperCase();
				rbt.add(upperStr);
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

	public static void Verify(RedBlackTrees rbt) {
        ArrayList<String> dict = new ArrayList<String>();
		int count = 0;
        try {
			String urlName = "http://www.math.sjsu.edu/~foster/dictionary.txt";
            URL dic = new URL(urlName);
            Scanner s = new Scanner(dic.openStream());
            dict.add(s.next());//adds the first line
			
            while (s.hasNextLine()) {
				String str = s.nextLine().trim();

				String upperStr = str.toUpperCase();
				if(!rbt.contains(upperStr)) count++;
            }
            s.close();
        }
		catch (IOException ex) { ex.printStackTrace(); }

		if(count == 0) System.out.println("All Tests Passed!");
		else System.out.println("Total Count: " + count);
    }

	public static void main(String[] args){
		RedBlackTrees rbt = new RedBlackTrees();

		LoadDictionary(rbt);

		Verify(rbt);

	}
}