/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake_And_Ladder_Simple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        Game snake_and_ladder = new Game();
        Player player;
        System.out.print("Input board size : ");
        snake_and_ladder.setBoard(Integer.parseInt(input.nextLine()));
        System.out.print("Input total player : ");
        snake_and_ladder.setPlayer(Integer.parseInt(input.nextLine()));
        
        for (int i = 0; i < snake_and_ladder.getPlayer() ; i++) {
            System.out.print("Input player " + (i+1) + " name : ");
            player = new Player(input.nextLine());
            snake_and_ladder.initPlayer(player);
        }
                                
        snake_and_ladder.RunGame();
        snake_and_ladder.RankingInfo();
        
    }
}

