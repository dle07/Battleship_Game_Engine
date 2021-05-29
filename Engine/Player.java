package Engine;


import java.util.Arrays;

/*

*/
public class Player {
    
    private boolean gameOver = false;
    
    protected Board player_board;
    
    
    public Player(int boardLength, int boardWidth){
        player_board = new Board(boardLength,boardWidth);
    

    }
    
    
    protected void shoot(int row, int col){
        player_board.visited[row][col] = true;


    }

    public boolean isGameOver(){
        return this.gameOver;
    }



}
