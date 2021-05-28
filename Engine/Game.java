package Engine;

import java.util.Scanner;


/*
    Destroyer ~ 2 Squares       Total : 9 squares
    Cruiser   ~ 3 Squares   
    Battleship ~ 4 Squares
*/
public class Game {

    boolean gameOver = false;
    Player user;
    Player computer;
    int boardLength;
    int boardWidth;
    String headerString;
    Scanner sc = new Scanner(System.in);

    public Game(){
        initialize_game();

        user = new Player( boardLength, boardWidth );
        computer = new ComputerPlayer();
        
    }
    private int[] getCordinates(){
        boolean areValidCordiantes = false;
        int x,y;
        int[] result = new int[2];
        System.out.println("Enter 2 space seperated numbers representing target cell in format <row> <column>, Ex: 1 3");
        String inputLine;
        String[] values;

        while(!areValidCordiantes){
            try {

                inputLine = sc.nextLine();
                values = inputLine.split(" ");
                result[0] = Integer.parseInt(values[0]);
                result[1] = Integer.parseInt(values[1]);
                if(!validCordinates(result[0], result[1])){
                    throw new IllegalArgumentException("Invalid Cordiantes, try again... ");
                }
                areValidCordiantes = true;
            } catch (Exception e) {
                printGameHeaders();
                printGameState();
            }

        }

        

    };
    private boolean validCordinates(int row, int col){
        if( row < 0 || row >= boardLength || col < 0 || col >= boardWidth){
            return false;
        }
        return true;
    }
    
    
    public void printGameHeaders(){
        StringBuilder temp = new StringBuilder("User");
        for( int i = 0 ; i < boardWidth + 4 ; i++)temp.append(' ');
        temp.append("Computer's Board");
        System.out.println(temp.toString());
        
    }

    public void startGame(){
        boolean isPlayerTurn = true;
        while( !user.isGameOver() && ! user.isGameOver()){
            if( isPlayerTurn ){
                int[] cordinates = getCordinates();
                user.shoot( cordinates[0] ,cordinates[1] );
            }
        }
    }

    public void printGameState(){
        System.out.println(headerString);
        for( int i = 0; i < boardLength ; i++){

            printRow(user, i);
            System.out.print(" | ");
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


    public void initialize_game(){
        boolean validInput = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Default Board length is 5x5");
        System.out.println("Board can exceed 5x5 dimension\n" + "Do you wish to customize length? (y/n)");

        String inputChoice = sc.nextLine();
        inputChoice = inputChoice.toLowerCase();

        do{
            validInput = false;
            if( inputChoice.equals("y") || inputChoice.equals("yes") ){
                this.customizeGame(sc);
                validInput = false;
            }else if( inputChoice.equals("n") || inputChoice.equals("no")){
            }else{
                System.out.println("Invalid input...\n Please input \"yes\" or \"y\" to set board dimensions or \"no\" or \"n\" to use default 5x5 dimension ");
                inputChoice = sc.nextLine();
            }
        }while( validInput == true );

        
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
                if( boardLength < 5){
                    System.out.println("Board Width not >= 5. Try again...");
                    continue;
                }
                invalidInput = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer >= 5");
            }
        }

    }


}
