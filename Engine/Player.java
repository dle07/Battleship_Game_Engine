package Engine;


import java.util.Arrays;

/*

*/
public class Player {
    
    private boolean gameOver = false;
    
    protected Board board;
    
    Player(){
        board = new Board();
        board.representation_board = new Character[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board.representation_board[i],'~');
        }

        
    }

    

    public boolean isGameOver(){
        return this.gameOver;
    }



}
