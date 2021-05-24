package Engine;
/*
    Destroyer ~ 2 Squares
    Cruiser 
*/
public class Game {

    boolean gameOver = false;
    Player user;
    Player computer;

    public Game(){
        user = new Player();
        computer = new ComputerPlayer();
        
    }
    public void startGame(){
        System.out.println("Battle Ship");
        System.out.println("User                   Computer");

        Game gameInstance = new Game();
        
        
    }

    public void printGameState(){
        System.out.println("0 1 2 3 4 5 6 7    1 2 3 4 5 6 7 8");
        for( int i = 0; i < 8 ; i++){
            printRow(user, i);
            System.out.print(" | ");
            printRow(computer,i);
            System.out.print(" " + i);
            System.out.println();

        }
    }

    public void printRow( Player player, int rowIndex ){
        StringBuilder temp = new StringBuilder();
        String result;
        for( int i = 0; i < 8 ; i++){
            temp.append( player.board.representation_board[rowIndex][i] + " ");
        }
        result = temp.toString();
        System.out.print(result);

    }


}
