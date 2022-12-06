import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import RedBlackTrees.RedBlackTrees;

public class Loading {
    RedBlackTrees rb = new RedBlackTrees();

    public boolean contains(ArrayList<String> s, String b) {

        if (s.contains(b)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> LoadDictionary() {
        ArrayList<String> dict = new ArrayList<String>();
        try {
            URL dic = new URL("http://www.math.sjsu.edu/~foster/dictionary.txt");
            Scanner s = new Scanner(dic.openStream());
            dict.add(s.next());//adds the first line
            while (s.hasNextLine()) {
                dict.add(s.nextLine());//adds all the rest of the lines
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Test");
        return dict;
    }

    public ArrayList<String> LoadPoem() {
        ArrayList<String> poem = new ArrayList<String>();
        try {
            URL dic = new URL("https://raw.githubusercontent.com/schmij03/RedBlackTreesDictionary/main/poem.txt");
            Scanner s = new Scanner(dic.openStream());

            poem.add(s.next());//ADDS first line
            while (s.hasNextLine()) {
                poem.add(s.nextLine());
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Test2");
        return poem;
    }

    public void printPoem() {
        ArrayList<String> c = LoadPoem();

        for (int i = 0; i < c.size(); i++) {

            System.out.println(c.get(i));
        }

    }

}
