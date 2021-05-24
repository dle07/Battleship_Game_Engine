package Engine;

import java.lang.reflect.Array;
import java.util.Arrays;

/*

*/
public class Player {
    private boolean gameOver = false;
    
    protected Character[][] representation_board;     // This board will be the representational board
    private int[][] actual_space;                   // This board represents the actual playing space.
    private boolean[][] visited;                    // 


    Player(){
        representation_board = new Character[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(representation_board[i],'~');
        }
        
    }

    public void generateRandomBoard(){

    }
    

    public boolean isGameOver(){
        return this.gameOver;
    }



}
