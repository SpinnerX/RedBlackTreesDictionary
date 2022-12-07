package RedBlackTrees;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Loading {
    RedBlackTrees rb = new RedBlackTrees();

    public boolean contains(ArrayList<String> s, String b) {

        if (s.contains(b)) {
            return true;
        } else {
            return false;
        }
    }
    // "http://www.math.sjsu.edu/~foster/dictionary.txt"
    public void LoadDictionary(RedBlackTrees rbt, String urlName) {
        try {
            URL dic = new URL(urlName);
            Scanner s = new Scanner(dic.openStream());
            rbt.add(s.next());//adds the first line
            while (s.hasNextLine()) {
                rbt.add(s.nextLine());//adds all the rest of the lines
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // "https://raw.githubusercontent.com/schmij03/RedBlackTreesDictionary/main/poem.txt"
    public void LoadPoem(RedBlackTrees rbt, String urlName) {
        try {
            URL dic = new URL(urlName);
            Scanner s = new Scanner(dic.openStream());

            rbt.add(s.next());//ADDS first line
            while (s.hasNextLine()) {
                rbt.add(s.nextLine());
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /*
    public void printPoem() {
        ArrayList<String> c = LoadPoem();

        for (int i = 0; i < c.size(); i++) {

            System.out.println(c.get(i));
        }

    }*/

}
