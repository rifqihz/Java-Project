/* Created By Rifqihz */
package java_project.morse_code_translator;

public class Translator {

    private String[] morseCode
            = { // minus = 1 dot = 0
                "10", //A
                "1000", //B
                "1010", //C
                "100", //D
                "0", //E
                "0010", //F
                "110", //G
                "0000", //H
                "00", //I
                "0111", //J
                "101", //K
                "0100", //L
                "11", //M
                "10", //N
                "111", //O
                "0110", //P
                "1101", //Q
                "010", //R
                "000", //S
                "1", //T
                "001", //U
                "0001", //V
                "011", //W
                "1001", //X
                "1011", //Y
                "1100", //Z
                "11111", // 0
                "01111", //1
                "00111", //2
                "00011", //3
                "00001", //4
                "00000", //5
                "10000", //6
                "11000", //7
                "11100", //8
                "11110", //9
            };
    private String plainText;
    private String morseText;
    private byte option;

    // Set User Option
    public void SetOption(byte input) {
        if (input == 1 || input == 2) {
            option = input;
        }
    }

    // Print Option list
    public void printOptionList() {
        System.out.println("|| Choice || ");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
    }

    public boolean checkUserChoice(byte userChoice) {
        return userChoice == 1  || userChoice == 2;
    }

    // Print the result
    public void printResult() {
        System.out.println("=== Result ===");
        if (option == 1) {
            System.out.println("Your text  : " + plainText);
            System.out.println("Morse Code : " + morseText);
        } else if (option == 2) {
            System.out.println("Your morse code : " + morseText);
            System.out.println("Plain text      : " + plainText);
        }
    }

    // Do the Encode or Decode and save the result
    public void RunTranslation(String input) {
        switch (option) {
            case 1:
                plainText = input.toUpperCase();
                morseText = Encode();
                break;
            case 2:
                morseText = input;
                plainText = Decode();
                break;
        }
    }

    // Encode the plain text into Morse 
    private String Encode() {
        String outputMorse = "";
        for (int i = 0; i < plainText.length(); i++) {
            if (((int) plainText.charAt(i) >= 65 && (int) plainText.charAt(i) <= 90)) {
                outputMorse += numToMorse((int) plainText.charAt(i) - 65) + " ";
            } else if ((int) plainText.charAt(i) == 32) {
                outputMorse += " ";
            } else if ((int) plainText.charAt(i) >= 48 && (int) plainText.charAt(i) <= 57) {
                outputMorse += numToMorse((int) plainText.charAt(i) - 22) + " ";
            }
        }
        return outputMorse;
    }

    // Change the number in array morseCode into character '-' if it's 1 and '.' if it's 0
    private String numToMorse(int i) {
        String numToMorseStr = "";
        for (int j = 0; j < morseCode[i].length(); j++) {
            if (morseCode[i].charAt(j) == '1') {
                numToMorseStr += '-';
            } else {
                numToMorseStr += '.';
            }
        }
        return numToMorseStr;
    }

    // Change the morse Code into char
    // If morse text isn't in morseCode array , the output will be changed with '#'
    private String Decode() {
        String outputPlainText = "";
        String save = "";
        boolean isMorse = false;
        for (int i = 0; i < morseText.length(); i++) {
            if (morseText.charAt(i) != ' ') {
                save += morseText.charAt(i);
                if(i == morseText.length() - 1){
                    for (int j = 0; j < morseCode.length; j++) {
                    if (morseToNum(save).equals(morseCode[j])) {
                        if (j < 26) {
                            outputPlainText += ((char) (j + 65)) + " ";
                        } else {
                            outputPlainText += ((char) (j + 10)) + " ";
                        }
                        isMorse = true;
                        break;
                    }
                }
                if (isMorse == false) {
                    outputPlainText += '#' + " ";
                }
                }
            } else {
                for (int j = 0; j < morseCode.length; j++) {
                    if (morseToNum(save).equals(morseCode[j])) {
                        if (j < 26) {
                            outputPlainText += ((char) (j + 65)) + " ";
                        } else {
                            outputPlainText += ((char) (j + 10)) + " ";
                        }
                        isMorse = true;
                        break;
                    }
                }
                if (isMorse == false) {
                    outputPlainText += '#' + " ";
                }
            save = "";
            }            
        }
        return outputPlainText;
    }

    // Change Morse code into 1 or 0
    private String morseToNum(String save) {
        String morseToNumStr = "";
        for (int i = 0; i < save.length(); i++) {
            if (save.charAt(i) == '-' || save.charAt(i) == '_') {
                morseToNumStr += '1';
            } else if (save.charAt(i) == '.' || save.charAt(i) == '*') {
                morseToNumStr += '0';
            }
        }
        return morseToNumStr;
    }

}
