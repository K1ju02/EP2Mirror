package AB1;

import AB1.Interfaces.Encoder;

/**
 * The {@code BrailleFont} class represents a set of printable Braille characters of type {@code byte[][]} and corresponding
 * mappings from ASCII characters ({@code char}) to this set.
 * <p>All printable characters are initialized at construction time and are of equal size (monospaced).</p>
 */
public class BrailleFont implements AB1.Interfaces.Font {

    // TODO: choose appropriate access modifier (public/private)
    private final int height;   // height of characters

    // TODO: choose appropriate access modifier (public/private)
    private final int width;    // width of characters (remark: font is monospaced)

    /**
     * A 3-dimensional array containing printable Braille characters (bitmaps) in ascending alphabetic order.
     * <p>In detail, it is an array of 2-dimensional matrices (bitmaps):
     * {@code lowerCaseLetters[index of character][bitMap row][bitmap column]}. Each bitmap contains dot and space symbols
     * according to the letter's Braille cell configuration.</p>
     * <p>The array does not include representations for non-letter characters or capital letters.
     * Other characters, such as white space, are handled separately.</p>
     *
     */
    // TODO: choose appropriate access modifier (public/private)
    private final char[][][] lowerCaseLetters;    // bitmaps for all lowercase letters

    /**
     * Represents the white space character .
     * <p>This array provides a printable representation (bitmap) of a white space within Braille texts.</p>
     * <p>The array is initialized during the construction of the {@code BrailleFont} object.</p>
     */
    // TODO: choose appropriate access modifier (public/private)
    private final char[][] whiteSpace;    // bitmap for the white space character (contains space symbols only)


    /**
     * Constructs a {@code BrailleFont} object and calculates the font's bitmaps.
     *
     * @param height        number of lines of font's characters (bitmap height)
     * @param width         number of columns of font's characters (bitmap width)
     * @param dotSymbol     the character used to represent a filled cell (dot) within a character's bitmap.
     * @param spaceSymbol   the character used to represent an empty cell (space) within a character's bitmap.
     * @param encoder       the Braille encoder ({@code class BrailleEncoder}) used to calculate the font's bitmaps at construction time.
     *                      <p>Precondition: (encoder != null)</p>
     */
    // TODO: choose appropriate access modifier (public/private)
    public BrailleFont(int height, int width, char dotSymbol, char spaceSymbol, Encoder encoder) {
        // TODO: implementation
        this.height = (height > 0) ? height : 1 ;
        this.width = (width > 0) ? width : 1;
        this.lowerCaseLetters = new char['z'-'a'+1][this.height][this.width];
        for (int i = 0; i <= ('z'-'a'); i++) {
            byte binaryRep = encoder.toBinary((char) ('a'+i));
            for(int j = 0; j < this.width; j++) {
                for (int k = 0; k < this.height; k++) {
                    this.lowerCaseLetters[i][k][j] = ((binaryRep & 1) == 1) ? dotSymbol : spaceSymbol;
                    binaryRep >>= 1;
                }
            }
        }
        this.whiteSpace = new char[this.height][this.width];
        for(int i = 0; i < this.height; i++) {
            for(int j = 0; j < this.width; j++) {
                this.whiteSpace[i][j] = spaceSymbol;
            }
        }

    }

    /**
     * Retrieves a bitmap ({@code char[][]}) of a given ASCII character.
     *
     * @param character the ASCII character for which a printable character will be returned.
     * @return a bitmap ({@code char[][]}) that corresponds to the given ASCII character.
     *         For letters, it returns the corresponding lowercase printable character from array {@code lowerCaseLetters[]}.
     *         For non-letters, it returns the representation of a white space ({@code whiteSpace}).
     */
    // TODO: choose appropriate access modifier (public/private)
    @Override
    public char[][] getBitmap(char character) {
        // TODO: implementation
        char[][] bitmap;
        character= Character.toLowerCase(character);

        if(character >= 'a' && character <= 'z' ) bitmap = lowerCaseLetters[character-'a'];
        else bitmap = whiteSpace;
        return bitmap;
    }

    /**
     * Returns the font's height.
     *
     * @return the number of rows of a character's bitmap.
     */
    // TODO: choose appropriate access modifier (public/private)
    @Override
    public int getHeight(){
        // TODO: implementation
    	return height;
    }

    /**
     * Returns the font's width (the font is monospaced).
     *
     * @return the number of columns of a character's bitmap.
     */
    // TODO: choose appropriate access modifier (public/private)
    @Override
    public int getWidth(){
        // TODO: implementation
        return width;
    }
}