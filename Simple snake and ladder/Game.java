/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake_And_Ladder_Simple;

import java.util.Arrays;
public class Game {
    
    private Player [] gamer;
    private int count = 0;
    private Board board = new Board();
                
    public void setPlayer(int player){
        gamer = new Player [player];        
    }        
    
    public void initPlayer(Player player){
        gamer[count] = player;
    }
    
    public int getPlayer(){
        return gamer.length;
    }
    
    public boolean countPlayer(){
        if(count == gamer.length){
            return true;
        }else{
            return false;
        }
    }
    
    public void runDice(){        
        for (int i = 0; i < gamer.length; i++) {
            gamer[i].runDice();
        }
    }
    
    public void setBoard(int size){
        board.setBoard(size);
    }
    
    public void RunGame(){
        int finish = 0;
        while(finish != gamer.length){
            for (Player player_game : gamer) {
                player_game.runDice();
            }
            for (Player player_game : gamer) {
                finish += player_game.getStatus();
            }
            if(finish != gamer.length){
                finish = 0;
            }
        }                
    }
    
    public void RankingInfo(){
        Arrays.sort(gamer);
        System.out.println("---Ranking---");
        for (int i = 0; i < gamer.length; i++) {
            System.out.println(i + ". " + gamer[i].getName() + " with " + gamer[i].getMove()) ;
        }
    }
    
}
