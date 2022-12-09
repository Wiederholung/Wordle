import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * To read the words from txt and check the words from user.
 * @author Yitong Hu
 * @version 2.0
 */
public class WordDB {
    // The array used to store the answer and the wordlist from DB.
    public static final char[] answer = new char[Style.WORD_LENGTH];
    public static final ArrayList<String> word = new ArrayList<>();


    /**
     * This method gets a random word from the word list amd stores it in the answer array.
     */
    public static void getAnswer(){
        String path;
        BufferedReader in;
        try {
            path = "../lib/WordDB.txt";
            new BufferedReader(new FileReader(path));
            System.out.println("Running by command line:");
        } catch (FileNotFoundException e) {
            path = "lib/WordDB.txt";
            System.out.println("Running by IDEA:");
        }
        String str;
        try {
            in = new BufferedReader(new FileReader(path));
            while ((str = in.readLine()) != null) {word.add(str);}   
            in.close();
        }
        catch (IOException e) {System.out.println("Exception thrown:" + e);}
        
        String ans = word.get(new Random().nextInt(word.size()-1));
        for (int i = 0; i < Style.WORD_LENGTH; i++) {answer[i] = ans.charAt(i);}
    }

    /**
     * This method checks if the key from user is in the wordlist.
     * @param key the key from user
     * @return Boolean
     */
    public static Boolean isWord(String key) {
        for (String i : word) {
            if (i.equals(key)) {return true;}
        }
        return false;
    }
}