package Engine;
/*
    Destroyer ~ 2 Squares
    Cruiser 
*/
public class Game {

    boolean gameOver = false;
    Game(){

    }
    public void startGame(){

    }

    public void printGameState( Player player1, Player player2 ){
        for( int i = 0; i < 8 ; i++){
            printRow(player1);
            System.out.print(" | ");
            printRow(player2);
            System.out.println();

        }
    }

    public void printRow( Player player ){
        for( int i = 0; i < 8 ; i++){
            System.out.print(player.representation_board[i] + " ");
        }
    }


}
