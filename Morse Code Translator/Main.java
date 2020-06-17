/* Created By Rifqihz */
package java_project.morse_code_translator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name;
        byte userChoice;
        String userText;
        Translator translatorMachine = new Translator();

        System.out.println("=== MORSE CODE TRANSLATOR ===");
        // Input the user name
        System.out.print("Input your username : ");
        name = input.nextLine();
        // Print option list 
        translatorMachine.printOptionList();
        System.out.print("Hello " + name + ", please input your choice : ");
        // Set userChoice and check it's correct or not
        userChoice = Byte.parseByte(input.nextLine());
        while (!translatorMachine.checkUserChoice(userChoice)) {
            System.out.println("\nThe option is 1 or 2");
            System.out.print("Please input the right choice : ");
            userChoice = Byte.parseByte(input.nextLine());
        }
        // Set userChoice in machine
        translatorMachine.SetOption(userChoice);

        // Input the plain / morse text
        if (userChoice == 1) {
            System.out.print("Input your text : ");
            userText = input.nextLine();
        } else {
            System.out.print("Input your morse code : ");
            userText = input.nextLine();
        }

        // Do the translation
        translatorMachine.RunTranslation(userText);
        // Print the result
        translatorMachine.printResult();

    }
}
