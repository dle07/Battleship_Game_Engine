package Engine;


import java.util.Arrays;

/*

*/
public class Player {
    
    private boolean gameOver = false;
    
    protected Board player_board;
    
    Player(){
        player_board = new Board();

        
    }

    

    public boolean isGameOver(){
        return this.gameOver;
    }



}
