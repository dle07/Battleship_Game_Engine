package Engine;


import java.util.Arrays;

/*

*/
public class Player {
    
    
    protected Board player_board;

    
    
    public Player(int boardLength, int boardWidth){
        player_board = new Board(boardLength,boardWidth);
    

    }
    
    
    protected void shoot(int row, int col, Player target){
        player_board.visited[row][col] = true;
        if( sucessfulHit(row, col, target)){
            target.player_board.board.get(row).set(col, 1);         // 1 for sucessful hit
        }else{  
            target.player_board.board.get(row).set(col,-1);         // -1 for unsucessful hit
        }


    }
    boolean sucessfulHit(int row, int col, Player target){
        return target.player_board.hiddenShipsBoard[row][col];
    }

    


}
