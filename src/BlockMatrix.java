import javax.swing.*;
import java.util.ArrayList;

/**
 * Form the blocks into matrix.
 * @author Yitong Hu
 * @version 1.0
 */
public class BlockMatrix {
    // Creat the block matrix array.
    private static final ArrayList<Block> block = new ArrayList<>();
    

    /**
     * This method is used to create the block matrix.
     * @return panel with the block matrix
     */
    public static JPanel initMatrix() {
        JPanel panel = new JPanel();
        for (int i = 0; i < Style.BLOCK_NUM; i++) {block.add(new Block());}
        for (Block b : block) {panel.add(b);}
        return panel;
    }

    /**
     * This method is used to get the text of the block.
     * @param index index in the block array
     * @return text in String
     */
    public static String getText(int index) {
        return block.get(index).getText();
    }

    /**
     * This method is used to set the text of the block.
     * @param index index in the block array
     * @param letter the letter to be set
     */
    public static void setText(int index, String letter) {
        block.get(index).setText(letter);
    }

    /**
     * This method is used to delete the text of the block.
     * @param index index in the block array
     */
    public static void delText(int index) {
        setText(index, "");
    }
    
    /**
     * This method is used to color the block.
     * @param index index in the block array
     * @param color the color to be set
     */
    public static void setColor(int index, char color) {
        switch (color) {
            case 'G' -> block.get(index).setBackground(Style.GREEN);
            case 'Y' -> block.get(index).setBackground(Style.YELLOW);
            default -> block.get(index).setBackground(Style.GRAY);
        }
    }


    /**
     * Inner class of BlockMatrix, used to customize the JLabel.
     * @author Yitong Hu
     * @version 1.2
     */
    private static class Block extends JLabel{
        // The default attributes of the blocks.
        public Block() {
            super("", JLabel.CENTER);
            setFont(Style.getTextFont());
            setForeground(Style.WHITE);
            setOpaque(true);
            setBackground(Style.GRAY);
            setPreferredSize(Style.BLOCK_SIZE);
        }
    }
}