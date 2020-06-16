/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project.character_counting;

public class Console_Input {

    private String consoleInput;
    private byte[] dataInput = new byte[95];
    private int unprintableCharacter = 0;
    private int words = 0;
    private int sentence = 0;
    private int alphabet = 0;
    private int number = 0;
    private int symbol = 0;
    private boolean isWords = false;

    // Set var consoleInput
    public void setConsoleInput(String input) {
        consoleInput = input;
        setByteInput();
    }

    // Assign array DataInput & unprintable Char
    // Assign array using Decimal Number
    private void setByteInput() {
        for (int i = 0; i < consoleInput.length(); i++) {
            byte characterByte = (byte) consoleInput.charAt(i);
            if ((byte) consoleInput.charAt(i) == 44 || (byte) consoleInput.charAt(i) == 32) {
                isWords = true;
            }
            if ((byte) consoleInput.charAt(i) == 46) {
                if ((byte) consoleInput.charAt(i + 1) != 46 && i != consoleInput.length() - 1) {
                    sentence++;
                }
            }
            if (characterByte >= 32 && characterByte <= 126) {
                dataInput[characterByte - 32]++;
                if (characterByte >= 65 && characterByte < 123) {
                    alphabet++;
                    if (words == 0) {
                        words++;
                    }
                    if (isWords) {
                        words++;
                        isWords = false;
                    }
                } else if (characterByte >= 48 && characterByte < 57) {
                    number++;
                } else {
                    symbol++;
                }
            } else {
                unprintableCharacter++;
            }
        }        
        if(words != 0 && sentence == 0){
            sentence = 1;
        }
            
        
    }

    // Print Statistic
    public void printDataStatistic() {
        System.out.println("\n===== STATISTIC =====");
        printCounting();
        System.out.println("\n== Alphabet ==");
        printAlphabet();
        System.out.println("== Number ==");
        printNumber();
        System.out.println("== Symbol ==");
        printSymbol();
        if (unprintableCharacter > 0) {
            System.out.println("== Unprintable Character ==");
            System.out.println("Unprintable Character : " + unprintableCharacter);
        }
    }

    public void printCounting() {
        System.out.println("Total alphabet : " + consoleInput.length());
        System.out.println("Total words    : " + words);
        System.out.println("Total sentence : " + sentence);
    }

    // Print assigned alphabet
    private void printAlphabet() {
        System.out.println("Total Alphabet : " + alphabet);
        for (byte i = 65; i < 123; i++) {
            if (dataInput[i - 32] > 0) {
                System.out.print((char) i + " : " + dataInput[i - 32]);
                System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
                if (i == 90) {
                    i += 6;
                }
            }
        }
    }

    // Print assigned Number
    private void printNumber() {
        System.out.println("Total Number : " + number);
        for (byte i = 48; i < 58; i++) {
            if (dataInput[i - 32] > 0) {
                System.out.print((char) i + " : " + dataInput[i - 32]);
                System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
            }
        }
    }

    // Print assigned Symbol
    private void printSymbol() {
        System.out.println("Total Symbol : " + symbol);
        for (byte i = 32; i < 48; i++) {
            if (dataInput[i - 32] > 0) {
                if (i == 32) {
                    System.out.print("space : " + dataInput[i - 32]);
                    System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
                } else if (i == 44 || i == 46) {
                } else {
                    System.out.print((char) i + " : " + dataInput[i - 32]);
                    System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
                }
            }
        }
        for (byte i = 58; i < 65; i++) {
            if (dataInput[i - 32] > 0) {
                System.out.print((char) i + " : " + dataInput[i - 32]);
                System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
            }
        }
        for (byte i = 94; i < 97; i++) {
            if (dataInput[i - 32] > 0) {
                System.out.print((char) i + " : " + dataInput[i - 32]);
                System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
            }
        }
        for (byte i = 123; i < 127; i++) {
            if (dataInput[i - 32] > 0) {
                System.out.print((char) i + " : " + dataInput[i - 32]);
                System.out.printf(" (%.2f%%) \n", (double) dataInput[i - 32] / consoleInput.length() * 100);
            }
        }

    }

}
