import javax.swing.*;
import java.awt.*;

/**
 * GUI components
 * @author Yitong Hu
 * @version 6.0
 */
public class GUI {
    private static JFrame frame;    // Need to be static to be accessed.


    /**
     * This method is the constructor of the GUI class.
     * Used to initialize layout, add components and listener of GUI.
     */
    public GUI() {
        // Initialize the frame
        frame = new JFrame("World");
        frame.setBounds(600,150,320,450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setFocusable(true);

        // add the panels to the frame
        frame.add(createTitlePanel(), BorderLayout.NORTH);
        frame.add(BlockMatrix.initMatrix(), BorderLayout.CENTER);

        // add the listener to the frame
        frame.addKeyListener(new PrintLetter());
    }

    /**
     * This method is used to create the title panel.
     * @return titlePanel with title "Wordle"
     */
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        JLabel label = new JLabel("Wordle");
        label.setFont(Style.getTitleFont());
        panel.add(label);
        return panel;
    }

    /**
     * This method is used to show the message and exit the program.
     * @param type 0: fail, 1: success, 2: not a word
     */
    public static void showMessage(int type) {
        if (type == 2) {JOptionPane.showMessageDialog(frame, "Not a word! \n Delete and try again.");}
        else {
            switch (type) {
                case 0 -> JOptionPane.showMessageDialog(frame, "You lose! \n The answer is " + String.valueOf(WordDB.answer) + ".");
                case 1 -> JOptionPane.showMessageDialog(frame, "Congratulations! You have completed the game.");
            }
            System.exit(0);
        }
    }
}