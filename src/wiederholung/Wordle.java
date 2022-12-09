package wiederholung;

/**
 * Main
 * @author Yitong Hu
 * @version 4.1
 */
public class Wordle {
    public static void main(String[] args) {
        // Initialize the word list
        WordDB.getAnswer();

        // Print the answer for debugging
        System.out.println(String.valueOf(WordDB.answer));

        // Initialize the GUI and start the game.
        new GUI();
    }
}