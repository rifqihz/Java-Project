import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Game {

    private Player[] player;
    private int countGame = 0;
    private byte totalPlayer;
    private Instant current;
    
    Game(){
        // init each Player class
        this.player = new Player[2];        
        player[0] = new Player();
        player[1] = new Player();
        
        // assign time when the Game object init
        current = Instant.now();        
    }         
    
    public String getName(byte i){
        return player[i].getName();
    }
    
    // assign name for computer
    public void setPlayerNum(byte player) {
        totalPlayer = player;        
        
        switch (player) {
            case 1:
                this.player[1].setName("Computer 1");
                this.player[1].setComputer();
                break;
            case 0:
                this.player[0].setName("Computer 1");
                this.player[0].setComputer();
                this.player[1].setName("Computer 2");
                this.player[1].setComputer();
                break;
        }
    }
    
    // Call set Choice
    public void setComputerChoice(byte i){
        player[i].setChoice();
    }    
    
    //set name 
    public void setPlayerName(byte number, String name) {
        this.player[number].setName(name);
    }

    // Set player Choice with input
    public void setPlayerChoice(byte i,String input){
        player[i].setChoice(input);
    }    
    
    // Return boolean player x is a computer or not
    public boolean isPlayeraComputer(byte i){
        return player[i].isComputer();
    }
    
    // return boolean exit is false/true
    public boolean Exit(char input){
        return input == 'y' || input == 'Y';
    }
    
    // Return question for naming
    public String getQuestion(byte i){
        if(i == 0){
            return "your";
        }else {
            return "opponent";
        }
    }
    
    //Return user (not computer)
    public byte getTotalUser(){
        return totalPlayer;
    }
    
    // Return all of player (2)
    public byte getTotalPlayer(){
        return (byte) player.length;
    }
    
    // Decide the winner 
    // Add point to each player
    // Print description
    private void setStatusTemp() {
        byte a = player[0].getChoiceByte();
        byte b = player[1].getChoiceByte();
        byte player1Win = 0;        
        if (a != 0 && b != 0) {
            if (a == b) {
                player[0].setPoint((byte) 0);                
                player[1].setPoint((byte) 0);
                player1Win = 0;
            } else if (a == 1) {
                if (b == 2) {
                    player[0].setPoint((byte) 1);
                    player[1].setPoint((byte) -1);
                    player1Win = 1;
                } else {
                    player[0].setPoint((byte) -1);
                    player[1].setPoint((byte) 1);
                    player1Win = -1;
                }

            } else if (a == 2) {
                if (b == 3) {
                    player[0].setPoint((byte) 1);
                    player[1].setPoint((byte) -1);
                    player1Win = 1;
                } else {
                    player[0].setPoint((byte) -1);
                    player[1].setPoint((byte) 1);
                    player1Win = -1;
                }
            } else if (a == 3) {
                if (b == 1) {
                    player[0].setPoint((byte) 1);                    
                    player[1].setPoint((byte) -1);
                    player1Win = 1;
                } else {
                    player[0].setPoint((byte) -1);
                    player[1].setPoint((byte) 1);
                    player1Win = -1;
                }
            }
        }
        // Print description of choice 
        System.out.println(player[0].getName() + " " + player[0].getChoiceStr());
        System.out.println(player[1].getName() + " " + player[1].getChoiceStr());
        switch (player1Win) {
            case 0:
                System.out.println("It's Draw !!! ");
                break;
            case 1:
                System.out.println(player[0].getName() + " win !!!");
                break;
            default:
                System.out.println(player[1].getName() + " win !!!");
                break;
        }
    }       
    
    //Run the Game
    public void runGame() {
        countGame++;
        setStatusTemp();        
    }
    
    
    //Print Final Standing
    public void printFinalStanding(){
        Instant done = Instant.now();
        long gapMin = ChronoUnit.MINUTES.between(current, done);
        long gapSec = ChronoUnit.SECONDS.between(current, done);
        System.out.println("\n=====Final Ranking=====");
        System.out.println("Total Time  : " + gapMin + " Minutes " + gapSec + " Seconds");
        System.out.println("Total Games : " + countGame);
        for (int i = 0; i < 2; i++) {
            System.out.println();
            System.out.println(player[i].getStat());            
        }
    }

    // Print choice info
    public void printChoice(){
        System.out.println("\nChoice : ");
        System.out.println("1. Rock");
        System.out.println("2. Scissor");
        System.out.println("3. Paper");
    }
    
    
}
