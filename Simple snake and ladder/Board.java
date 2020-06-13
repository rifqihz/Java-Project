/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake_And_Ladder_Simple;

import java.util.Random;
public class Board {
    private int [] board;    
            
    
    public void setBoard(int input) {
        board = new int[input];
        for (int i = 0; i < board.length; i ++) {
            board [i] = i+1;
        }
    }
    
    public int runDice(){
        Random randnum = new Random((12-1) + 1);
        int out = randnum.nextInt();
        return out;
    }
    
    public int [] getBoard(){
        return board;
    }    
    public int getBoardLength(){
        return board.length;
    }
    
    
}
