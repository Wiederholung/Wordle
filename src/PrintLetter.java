import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Listen the keyboard and print letters to the blocks.
 * @author Yitong Hu
 * @version 1.0
 */
public class PrintLetter extends KeyAdapter{
    private final ArrayList<String> temp = new ArrayList<>();
    private int ptr;
    private final char[] word = new char[Style.WORD_LENGTH];   // The word from user.


    /**
     * This method is used to get the key from user, print the letter and call the Coloring.startColoring(word, ptr);.
     * @param e the key event
     */
    @Override
    public void keyPressed(KeyEvent e){
        String key = String.valueOf(e.getKeyChar()).toLowerCase();

        // If the key is a letter, add the letter to the block.
        if (KeyEvent.VK_A <= e.getKeyCode() && e.getKeyCode() <= KeyEvent.VK_Z) {
            if (temp.size() < Style.WORD_LENGTH) {
                temp.add(key);
                BlockMatrix.setText(ptr, key);
                ptr++;
            }
        }

        // If the key is backspace, delete the last letter.
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (temp.size() > 0) {
                temp.remove(temp.size()-1);
                BlockMatrix.delText(ptr-1);
                ptr--;
            }
        }
        
        // If the key is entered, check the result.
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (temp.size() == Style.WORD_LENGTH) {
                // System.out.println(String.join("", temp));
                if (WordDB.isWord(String.join("", temp))) {
                    temp.clear();
                    for (int i = ptr-Style.WORD_LENGTH; i < ptr; i++) {word[i-ptr+Style.WORD_LENGTH] = BlockMatrix.getText(i).toCharArray()[0];}

                    // Color the block.
                    Coloring c = new Coloring();
                    c.startColoring(word, ptr);

                    // Judge the result and quit the game.
                    int n = c.getGreenNum();
                    if (n == Style.WORD_LENGTH) {GUI.showMessage(1);}
                    if (!Objects.equals(BlockMatrix.getText(Style.BLOCK_NUM - 1), "") && n != Style.WORD_LENGTH) {GUI.showMessage(0);}
                }
                else {GUI.showMessage(2);}
            }
        }
    }
}