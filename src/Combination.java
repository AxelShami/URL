import java.util.ArrayList;
import java.util.Scanner;

public class Combination {
    static ArrayList<String> words = new ArrayList<>();
    String letters;


    public Combination(String word) {
        letters = word;
    }

    public void shuffle (){

        int positionLetter = letters.length();
        while (positionLetter != 0 ){
            word();

            letters = letters.charAt(letters.length()-1) + letters;
            // Remove the last letter
            letters = letters.substring(0,letters.length()-1);
            positionLetter--;
        }
    }

    public void word (){
        int index = letters.length() - 3;
        int indexLetter = letters.length()-2;
        char first_char = 0;

         /* Note personnel :
        ex : m-e-t-e-t-i
             m-e-t-e-i-t

          donc on augmente les swip...

        -->  m-e-t-t-i-e
             m-e-t-t-e-i

        -->  m-e-t-i-e-t
             m-e-t-i-t-e

        -->  m-e-t-e-t-i (the condition is met so we increase our range of swips)
             m-e-(letters that are going to be swip)
        */
        if (first_char == letters.charAt(index)) {
            if (index == 1)
            /** on aura fini*/ // I was crazy
                index--;
        }

        add_word();
        /** */
        swiping_lastTwoLetters();
        add_word();
        swiping_lastTwoLetters();

        first_char = letters.charAt(index);

        letters = string_swap(index, letters.length() - 1);

    }

    /** I have decided to create this class cause... */
    public void swiping_lastTwoLetters(){
        letters = string_swap( letters.length() - 1, letters.length() - 2);
    }
    public void add_word(){
        words.add(letters);
    }

    // Found it online : https://stackoverflow.com/questions/956199/how-to-swap-string-characters-in-java
    public String string_swap(int x, int y)
    {

        if( x < 0 || x >= letters.length() || y < 0 || y >= letters.length())
            return "Invalid index";

        char arr[] = letters.toCharArray();
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;

        return new String(arr);
    }
}
