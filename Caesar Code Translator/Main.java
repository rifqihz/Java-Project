/* Created By Rifqihz */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name; // For username
        byte userTranslateChoice; // For user choice (encode(1) or decode(2))
        String userText; // User input text (caesar /plain text)
        String decodeOption; // User choice in decode (decode with shift number or try all possibilities)
        String userKeyChoice; // user choice(use default key or user's own key)
        int shift; // Set the shift number

        Translator caesarTranslator = new Translator();

        System.out.println("Created by Rifqihz");        
        System.out.println("\n=== CAESAR TRANSLATOR ===");
        
        System.out.print("Input your username : ");        
        name = input.nextLine();
        
        // Print option list 
        caesarTranslator.printOptionList();
        System.out.print("Hello " + name + ", please input your choice : ");
        
        // Set userChoice and check its format
        userTranslateChoice = Byte.parseByte(input.nextLine());
        while (!caesarTranslator.checkUserChoiceFormat(userTranslateChoice)) {
            System.out.println("\nThe option is 1 or 2");
            System.out.print("Please input the right choice : ");
            userTranslateChoice = Byte.parseByte(input.nextLine());
        }
        
        // Set userChoice into CaesarTranslator 
        caesarTranslator.SetOption(userTranslateChoice);

        // Print default key
        caesarTranslator.printDefaultKey();
        
        // Set userKeyChoice(use default key or use user own key)
        // Check the user input format
        System.out.print("Do you want to use default key ?[Y|N] : ");
        userKeyChoice = input.nextLine();
        while (!caesarTranslator.checkYesOrNoFormat(userKeyChoice)) {
            System.out.println("\nThe option is Y or Yes and n or No");
            System.out.print("Please input the right choice : ");
            userKeyChoice = input.nextLine();
        }

        // Input user's key and set it into caesarTranslator
        if (caesarTranslator.useDefaultKey(userKeyChoice) == false) {
            String newKey;
            System.out.print("Please input your own key : ");
            newKey = input.nextLine();
            caesarTranslator.setNewKey(newKey);
        }
        
        // Check user choice , 1 for encode and 2 for decode
        
        // Encode
        if (userTranslateChoice == 1) {
            
            // Input user plaintext to encode & assign it into caesarTranslator
            System.out.print("Input your plain text  : ");
            userText = input.nextLine();
            caesarTranslator.setInputUser(userText);
            
            // Input the shift number
            System.out.println("Please input shift number, it's between 1 and " + caesarTranslator.getKeyLength());
            System.out.print("Shift : ");
            
            // Input shift and check the shift format
            shift = Integer.parseInt(input.nextLine());            
            while (!caesarTranslator.checkUserShiftFormat(shift)) {
                System.out.println("\nThe option is between 1 until " + caesarTranslator.getKeyLength());
                System.out.print("Please input the right choice : ");
                shift = Integer.parseInt(input.nextLine());
            }

            // Set shift into caesarTranslator
            caesarTranslator.setShift(shift);

        // Decode
        } else {
            // Input user plaintext to encode & assign it into caesarTranslator
            System.out.print("Input your caesar text : ");
            userText = input.nextLine();
            caesarTranslator.setInputUser(userText);
            
            // Ask if user want to decode all possibilities
            System.out.print("Do you want to decode all possibilities?[Y|N] : ");
            
            // Assign input into decodeOption and check its format
            decodeOption = input.nextLine();
            while (!caesarTranslator.checkYesOrNoFormat(userKeyChoice)) {
                System.out.println("\nThe option is Y or Yes and n or No");
                System.out.print("Please input the right choice : ");
                decodeOption = input.nextLine();
            }
             
            // Assign decodeOption into caesarTranslator
            caesarTranslator.setDecodeoption(decodeOption);
            
            // If the user doesn't want to decode all possibilities so user should input the shift number
            if (caesarTranslator.decodeAllPos(decodeOption) == false) {               
                System.out.println("Please input shift number, it's between 1 and " + caesarTranslator.getKeyLength());
                System.out.print("Shift : ");
                
                // Assign input into shift variable and check its format
                shift = Integer.parseInt(input.nextLine());               
                while (!caesarTranslator.checkUserShiftFormat(shift)) {
                    System.out.println("\nThe option is between 1 until " + caesarTranslator.getKeyLength());
                    System.out.print("Please input the right choice : ");
                    shift = Integer.parseInt(input.nextLine());
                }
                
                // if correct assign shift into caesarTranslator
                caesarTranslator.setShift(shift);
            }                                    
            
            // If user want to decode all possibilites, so user doesn't need to input the shift number
        }

        // Print result
        caesarTranslator.printResult();

    }
}
