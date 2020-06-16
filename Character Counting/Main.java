import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        Console_Input consoleInput = new Console_Input();
        
        System.out.print("Input your text : ");
        consoleInput.setConsoleInput(input.nextLine());
        consoleInput.printDataStatistic();
    }
}
