import java.util.Random;

public class Player {

    private String name;
    private byte win = 0;
    private byte draw = 0;
    private byte lose = 0;    
    private byte choice;
    private boolean computer = false;

    public void setName(String player) {
        name = player;
    }        

    public void setComputer(){
        computer = true;
    }       
    
    public boolean isComputer(){
        return computer;
    }
    
    public byte getChoiceByte(){
        return choice;
    }
    
    public String getName(){
        return name;
    }    
    
    //Set player point 
    public void setPoint(byte data) {
        switch (data) {
            case 1:
                win++;
                break;
            case 0:
                draw++;
                break;
            case -1:
                lose++;
                break;
        }
    }
    
    // Return Statistic for final standings
    public String getStat(){
        return "Name  \t: " + name + 
               "\nWin \t: " + win + 
               "\nLose\t: " + lose + 
               "\nDraw\t: " + draw;                
    }        
    
    // User Choice (String input)
    public void setChoice(String choice){        
        if(choice.equalsIgnoreCase("rock")){
            this.choice = 1;
        }else if(choice.equalsIgnoreCase("scissor")){
            this.choice = 2;
        }else if(choice.equalsIgnoreCase("paper")){
            this.choice = 3;
        }else if("1".equals(choice)){
            this.choice = Byte.parseByte(choice);
        }else if("2".equals(choice)){
            this.choice = Byte.parseByte(choice);
        }else if("3".equals(choice)){
            this.choice = Byte.parseByte(choice);
        }else{
            this.choice = 0;
        }
    }
    
    // Computer Choice (Random)
    public void setChoice(){
        Random randnum = new Random();
        choice = (byte) ((byte) randnum.nextInt((3 - 1) + 1) + 1);        
    }
    
    // return a choice in String format
    public String getChoiceStr(){
        switch(choice){
            case 1: 
                return "rock";
            case 2:
                return "scissor";
            case 3: 
                return "paper";
            default:
                return "Error input";
        }
    }       

}
