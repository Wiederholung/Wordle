/**
 * Color the blocks.
 * @author Yitong Hu
 * @version 1.2
 */
public class Coloring {
    private final int[] wordColor = new int[Style.WORD_LENGTH];     // 0: gray, 1: green, 2: yellow
    private final int[] letterCheck = new int[Style.WORD_LENGTH];   // 0: not checked, 1: checked
    private int greenNum;                                     // number of green letters


    /**
     * This method is used to coloring the blocks by the word from user.
     * @param word the word from user
     * @param index the index of the block to be colored
     */
    public void startColoring(char[] word, int index) {
        // Compare the answer array with the word array and store the color of each block in the wordColor array.
        for (int i = 0; i < Style.WORD_LENGTH; i++) {
            for (int j = 0; j < Style.WORD_LENGTH; j++) {
                if (word[i]==WordDB.answer[j] && letterCheck[j]==0) {
                    letterCheck[j] = 1;
                    if (i == j) wordColor[i] = 1;
                    else wordColor[i] = 2;
                    break;
                }
            }
            if (word[i]==WordDB.answer[i] && wordColor[i]!=1) {
                for (int k = 0; k < i; k++) {
                    if (word[k]==word[i] && wordColor[k]==2) {
                        wordColor[k] = wordColor[i];
                        wordColor[i] = 1;
                    }
                }
            }
        }
        
        // Color the blocks and count the number of green letters per row.
        for (int i = 0; i < Style.WORD_LENGTH; i++) {
            if (wordColor[i] == 1) {
                BlockMatrix.setColor(i+index-Style.WORD_LENGTH, 'G');
                greenNum++;
            }
            if (wordColor[i] == 2) BlockMatrix.setColor(i+index-Style.WORD_LENGTH, 'Y');
        }
    }

    /**
     * This method is used to get the number of green letters.
     * @return the number of green letters per row
     */
    public int getGreenNum() {
        return greenNum;
    }
}