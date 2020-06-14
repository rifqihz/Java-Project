import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        boolean play = true;

        System.out.println("Created by Rifqihz");
        System.out.println("Welcome to Rock Paper & Scissor Game !!!");

        System.out.print("\nInput the number of player (max 2) : ");
        game.setPlayerNum(Byte.parseByte(input.nextLine()));
        for (byte i = 0; i < game.getTotalUser(); i++) {
            System.out.print("Input " + game.getQuestion(i) + " name : ");
            game.setPlayerName(i, input.nextLine());
        }

        game.printChoice();

        while (play) {
            for (byte i = 0; i < game.getTotalPlayer(); i++) {
                if (game.isPlayeraComputer(i)) {
                    game.setComputerChoice(i);
                } else {
                    if (game.getTotalUser() == 2) {
                        System.out.println("Input " + game.getName(i) + " choice : ");
                        game.setPlayerChoice(i, input.nextLine());
                    } else if (game.getTotalUser() == 1) {
                        System.out.print("Input your choice : ");
                        game.setPlayerChoice(i, input.nextLine());
                    }
                }
            }

            game.runGame();
            System.out.print("Do you want to quit?[Y|N] : ");
            if (game.Exit(input.next().charAt(0))) {
                play = false;
            }
            input.nextLine();
            System.out.println();
        }

        game.printFinalStanding();

    }
}
