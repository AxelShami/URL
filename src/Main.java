import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the letters (Order doesn't matter)");
        String letters = sc.next();

        Combination new_word = new Combination(letters);
        new_word.shuffle();
    }
}