/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake_And_Ladder_Simple;

public class Player extends Board {
    private String name;
    private int pos;            
    private boolean status;
    private int count = 0;
    
    Player(String name){        
        this.name = name;
    }
    
    public void checkPos(){
        if(pos > super.getBoard().length){
            pos = super.getBoard().length - (pos - super.getBoard().length);
        }
    }
    
    public void setPos(){       
        this.pos += super.runDice();
        checkPos();
        count++;
    }
    
    public void done(){
        if(pos != super.getBoardLength()){
            status =  true;
        }else{
        status = false;
        }
    }
    
    public int getStatus(){
        return status?1:0;
    }
    
    public String toString(){
        return "";
    }
    
    public int getMove(){
        return count;
    }
    
    public String getName(){
        return name;
    }
}
