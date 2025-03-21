package AB1;

/**
 * This class implements an encoder from ASCII character to Braille binary representation.
 * In Braille binary representation a 2D Braille cell is represented by one byte,
 * where each dot is mapped to one specific bit.
 *
 * <p> The encoder utilizes a lookup table ({@code brailleLUT}) of predefined binary values
 * corresponding to ASCII characters </p>
 */
public class BrailleEncoder implements AB1.Interfaces.Encoder {

    /**
     * Lookup table (LUT) for Braille character encoding.
     *
     * <p>This array holds the Braille cells binary representation for all lower case ASCII letters ('a' to 'z').
     * Index 0 corresponds to letter 'a', index 1 to letter 'b', index 2 to letter 'c' and so on.
     * The binary representation of each letter specifies which dots are set within the letter's Braille cell,
     * a 2x3 dot matrix configuration of specific dots set (1 or 0).</p>
     *
     * The LUT must be used by the class method {@code toBinary}.
     */
    // TODO: choose appropriate access modifier (public/private)
    private static final byte[] brailleLUT = {
            0b000_001,   // a
            0b000_011,   // b
            0b001_001,   // c
            0b011_001,   // d
            0b010_001,   // e
            0b001_011,   // f
            0b011_011,   // g
            0b010_011,   // h
            0b001_010,   // i
            0b011_010,   // j
            0b000_101,   // k
            0b000_111,   // l
            0b001_101,   // m
            0b011_101,   // n
            0b010_101,   // o
            0b001_111,   // p
            0b011_111,   // q
            0b010_111,   // r
            0b001_110,   // s
            0b011_110,   // t
            0b011_011,   // u
            0b100_101,   // v
            0b111_010,   // w
            0b101_101,   // x
            0b111_101,   // y
            0b110_101    // z

            // TODO: complete the array: add binary representation for letters f-z
            //       for details on the Braille alphabet see
            //       https://de.wikipedia.org/w/index.php?title=Brailleschrift#Systematik_des_Punkteaufbaus
    };

    /**
     * Encoder for ASCII to binary representation of a Braille cell.
     *
     * <p>This method encodes a given ASCII character from range [a-z] to it's
     * corresponding Braille binary representation. The method implementation relies on the lookup table (LUT) {@code brailleLut}. </p>
     *
     * @param asciiChar an ASCII character from the lower case alphabet ['a','z']
     *                  <p>Precondition: (asciiChar>='a') && (asciiChar<='z')</p>
     */
    // TODO: choose appropriate access modifier (public/private)
    @Override
    public byte toBinary(char asciiChar) {
        // TODO: implementation
        if(asciiChar >= 'a' && asciiChar <= 'z') {
            return brailleLUT[asciiChar-'a'];
        }
        return 0;
    }


}
