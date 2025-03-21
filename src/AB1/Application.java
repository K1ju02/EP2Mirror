package AB1;

import AB1.Interfaces.Encoder;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the LinePrinter, configured with a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
public class Application {
    public static void main(String[] args) {

        // example from documentation
        LinePrinter lp=new  LinePrinter(
                                new BrailleFont(
                                        3,
                                        2,
                                        'o',
                                        '.',
                                        new BrailleEncoder()),
                                20,
                                4
                            );
        lp.printString("Hello World");
        lp.flush();

        // TODO: implementation of any developer specific tests (optional)

        LinePrinter alphPrinter = new LinePrinter(
                new BrailleFont(
                            3,
                            2,
                            'x',
                            'o',
                            new BrailleEncoder()
                ),
                26,
                2
                );
        System.out.println("AlphPrinter lowercase Alphabet:");
        alphPrinter.printString("abcdefghijklmnopqrstuvwxyz");
        alphPrinter.flush();
        System.out.println("AlphPrinter uppercase Alphabet:");
        alphPrinter.printString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        alphPrinter.flush();
        System.out.println("AlphPrinter uppercase Alphabet with dots over char limit:");
        alphPrinter.printString("ABCDEFGHIJKLMNOPQRSTUVWXYZ.....");
        alphPrinter.flush();

        alphPrinter.printCharacter('a');
        alphPrinter.flush();
        alphPrinter.printCharacter('0');
        alphPrinter.flush();
        alphPrinter.printCharacter('_');
        alphPrinter.flush();

        LinePrinter bigFont = new LinePrinter(
                new BrailleFont(
                        5,
                        4,
                        'w',
                        'o',
                        new BrailleEncoder()
                ),
                26,
                2
        );
        bigFont.printString("Hello World");
        bigFont.flush();

        LinePrinter smallFont = new LinePrinter(
                new BrailleFont(
                        2,
                        3,
                        'o',
                        '.',
                        new BrailleEncoder()
                ),
                26,
                2
        );
        smallFont.printString("ablz");
        smallFont.flush();

        LinePrinter smallerOne = new LinePrinter(
                new BrailleFont(
                        -1,
                        -1,
                        'o',
                        '.',
                        new BrailleEncoder()
                ),
                26,
                2
        );
        smallerOne.printString("abi");
        smallerOne.flush();
    }
}