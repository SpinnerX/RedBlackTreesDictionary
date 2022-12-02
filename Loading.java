import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Loading {
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

            while (s.hasNextLine()) {
                dict.add(s.nextLine());
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
            File dic = new File("C:\\Users\\jansc\\Downloads\\poem.txt");
            Scanner s = new Scanner(dic);

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

    public void printPoem(){
        ArrayList<String>c = LoadPoem();

        for (int i=0; i<c.size();i++){

            System.out.println(c.get(i));
        }


    }
}