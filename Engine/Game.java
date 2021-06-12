package Engine;

import java.util.Scanner;

import jdk.jfr.ValueDescriptor;



/*
    Destroyer ~ 2 Squares       Total : 9 squares
    Cruiser   ~ 3 Squares   
    Battleship ~ 4 Squares
*/
public class Game {

    boolean gameOver = false;
    Player user;
    ComputerPlayer computer;
    static int boardLength = 5;
    static int boardWidth  = 5;
    String headerString;
    boolean playAgain = true;
    Scanner sc = new Scanner(System.in);
    

    public Game(){
        initialize_game();
        user = new Player( boardLength, boardWidth );
        computer = new ComputerPlayer(boardLength, boardWidth);

        generateStringHeader();
        printGameState();
        
    }
    
    private int[] getCordinates(Player target){
        boolean areValidCordiantes = false;
        int[] result = new int[2];
        System.out.println("Enter 2 space seperated numbers representing target cell in format <row> <column>, Ex: 1 3");
        String inputLine;
        String[] values;

        while(!areValidCordiantes){
            try {

                inputLine = sc.nextLine();
                values = inputLine.trim().split("\\s+");
                result[0] = Integer.parseInt(values[0]);
                result[1] = Integer.parseInt(values[1]);
                for( String value : values){
                    System.out.println(value);
                }
                if(!validCordinates(result[0], result[1],target)){
                    throw new IllegalArgumentException("Invalid Cordiantes, try again... ");
                }
                areValidCordiantes = true;
            } catch (Exception e) {
                System.out.println(e);
                printGameState();
            }

        }

        return result;

    };
    private boolean validCordinates(int row, int col, Player target){
        if( row < 0 || row >= target.player_board.boardLength || col < 0 || col >= target.player_board.boardWidth || target.player_board.visited[row][col] ){
            return false;
        }
        return true;
    }
    


    public void startGame(){
        boolean isPlayerTurn = true;
        while( playAgain ) {
            
            while( !checkIfLost(user) && !checkIfLost(computer)){

                printGameState();
                int[] cordinates = getCordinates(user);
                user.shoot( cordinates[0] ,cordinates[1], computer );   //User's turn to shoot
                if(checkIfLost(computer)){
                    System.out.println("You have won!!!");
                    break;
                }
                computer.shoot(user);                                       //Computer shoots
                if( checkIfLost(user)){
                    System.out.println("You have been defeated!!!");
                    break;
                }
                
            }
            playAgainPrompt();
            if(playAgain){
                resetGameState();
            }

        }
        
    }
    protected void playAgainPrompt(){
        System.out.println("\n\nWould you like to play again? (y/n)");
        boolean validInput = false;   //Assume it's not a valid input

        String inputChoice = sc.nextLine();
        inputChoice = inputChoice.toLowerCase();

        do{
            
            if( inputChoice.equals("y") || inputChoice.equals("yes") ){
                validInput = true;
            }else if( inputChoice.equals("n") || inputChoice.equals("no")){
                validInput = true;
                playAgain = false;
            }else{
                System.out.println("Invalid input...\n Please input \"yes\" or \"y\" to play again or \"no\" or \"n\" to exit");
                inputChoice = sc.nextLine();
            }
        }while( !validInput );

    }
    


    public void initialize_game(){
        boolean validInput = false;

        System.out.println("Default Board length is 5x5");
        System.out.println("Board can exceed 5x5 dimension\n" + "Do you wish to customize length? (y/n)");

        String inputChoice = sc.nextLine();
        inputChoice = inputChoice.toLowerCase();

        do{
            
            if( inputChoice.equals("y") || inputChoice.equals("yes") ){
                this.customizeGame(sc);
                validInput = true;
            }else if( inputChoice.equals("n") || inputChoice.equals("no")){
                validInput = true;
            }else{
                System.out.println("Invalid input...\n Please input \"yes\" or \"y\" to set board dimensions or \"no\" or \"n\" to use default 5x5 dimension ");
                inputChoice = sc.nextLine();
            }
        }while( !validInput  );
        
    }


    void customizeGame(Scanner sc){
        boolean invalidInput = true;
        String temp;
        while(invalidInput){
            try {
                System.out.print("Input new length:   ");
                temp = sc.next();
                boardLength = Integer.parseInt(temp);
                if( boardLength < 5){
                    System.out.println("Board Length not >= 5. Try again...\n");
                    continue;
                }
                invalidInput = false;
            } catch (Exception e) {
                System.out.println("Invalid Input, enter an integer...\n");
            }
        }
        invalidInput = true;
        while(invalidInput){
            try {
                System.out.println("Input new Width: ");
                temp = sc.next();
                boardWidth = Integer.parseInt(temp);
                if( boardWidth < 5){
                    System.out.println("Board Width not >= 5. Try again...");
                    continue;
                }
                invalidInput = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer >= 5");
            }
        }

    }


    public void printGameState(){
        StringBuilder temp = new StringBuilder("User");
        for( int i = 0 ; i < boardWidth + 4 ; i++)temp.append(' ');
        temp.append("Computer's Board");
        System.out.println(temp.toString());
        System.out.println(headerString);
        for( int i = 0; i < boardLength ; i++){

            printRow(user, i);
            System.out.print(" |  ");
            printRow(computer,i);
            System.out.print(" " + i);
            System.out.println();

        }
    }

    public void printRow( Player player, int rowIndex ){
        StringBuilder temp = new StringBuilder();
        Integer currentInt;

        for( int i = 0; i < boardWidth ; i++){
            currentInt = player.player_board.board.get(rowIndex).get(i);
            
            if(currentInt.equals(-1)){
                temp.append("O ") ; 
            }
            else if( currentInt.equals(0)){
                temp.append("~ ") ;
            }
            else{
                temp.append("X ");
            }
            
        }
        System.out.print(temp.toString());
    }

    private void generateStringHeader(){

        StringBuilder headerBuilder = new StringBuilder();
        
        for( int i = 0; i < boardWidth; i++){
            headerBuilder.append(i + " ");
        }
        headerBuilder.append("    ");
        for( int i = 0; i < boardWidth; i++){
            headerBuilder.append(i + " ");
        }
        this.headerString = headerBuilder.toString();

    }

    protected boolean checkIfLost(Player target){
        for( int i = 0; i < boardLength; i++){
            for( int j = 0; j < boardWidth; j++){
                if( target.player_board.hiddenShipsBoard[i][j]){
                    if( !target.player_board.board.get(i).get(j).equals(1)) return false;
                }
            }
        }

        return true;
    }


    protected void resetGameState(){
        for( int i = 0; i < boardLength; i++){
            for( int j = 0; j < boardWidth; j++){
                user.player_board.board.get(i).set(j,0);
                user.player_board.visited[i][j] = false;
                
                computer.player_board.board.get(i).set(j,0);
                computer.player_board.visited[i][j] = false;
            }
        }
    }


    static protected boolean inBounds(int row, int col){
        if( row < 0 || row >= boardLength || col < 0 || col >= boardWidth ) return false;
        return true;
    }
}
