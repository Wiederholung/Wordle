package wiederholung;

import java.awt.*;

/**
 * The style of app, such as block size, color and font.
 * @author Yitong Hu
 * @version 4.0
 */
public class Style {
	// The default attributes of the blocks.
    public static final int WORD_LENGTH = 5;
    public static final int GUESS_NUM = 6;
	public static final int BLOCK_NUM = WORD_LENGTH * GUESS_NUM;
    public static final Dimension BLOCK_SIZE = new Dimension(50, 50);

    // The colors used in the application
	public static final Color GRAY = new Color(120, 124, 126);
	public static final Color GREEN = new Color(106, 170, 100);
	public static final Color YELLOW = new Color(201, 180, 88);
	public static final Color WHITE = new Color(255, 255, 255);

    // The fonts' style used in the application
	public static Font getTitleFont() {return new Font("Dialog", Font.BOLD, 36);}	
	public static Font getTextFont() {return new Font("Dialog", Font.PLAIN, 25);}
}
