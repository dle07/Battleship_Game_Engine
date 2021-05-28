package Engine;


import java.util.Arrays;

/*

*/
public class Player {
    
    private boolean gameOver = false;
    
    protected Board player_board;
    
    
    Player(int boardLength, int boardWidth){
        player_board = new Board();
    

        
    }

    
    protected void shoot(int row, int col){
        
    }
    public boolean isGameOver(){
        return this.gameOver;
    }



}
