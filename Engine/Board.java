package Engine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    
    protected ArrayList<ArrayList<Integer>>    board;                  // This board represents the actual playing space.
    protected boolean[][]                      hiddenShipsBoard;       // Used to represent Where our ships are really hidden
    protected boolean[][]                      visited;                //
    protected int boardLength = 5;
    protected int boardWidth = 5;
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,1,0,-1};

    protected static Random rand = new Random();

    public Board(int boardLength, int boardWidth){

        this.boardLength = boardLength;
        this.boardWidth = boardWidth;
        board = new ArrayList<> (boardLength);          
        visited = new boolean[boardLength][boardWidth];                                  // Initally set to false, no need to continue
        hiddenShipsBoard = new boolean[boardLength][boardWidth]; 
        this.generateRandomBoard();
        
        for( int i = 0; i <boardLength ; i++){
            ArrayList<Integer>   temp  =  new ArrayList<Integer>(Collections.nCopies(boardWidth, 0)); 
            this.board.add(temp);
        }
        
    };

    protected boolean isValidLocation( int row, int column){
        if( row < 0 || row >= boardLength || column < 0 || column >= boardWidth || visited[row][column]){
            return false;
        }

        return true;
    }
    protected boolean validBounds(int row, int col){
        if(row < 0 || row >= boardLength || col < 0 || col >= boardWidth){
            return false;
        }
        return true;
    }

    public void generateRandomBoard(){
        for( Ships ship: Ships.values()){
            System.out.println("Placing " + ship + "........");
            this.placeShipRandomly(ship);
        }
    }

    private void placeShipRandomly(Ships shipType){
    
        boolean canPlaceShip = false;
        int length;
        int nextRow;
        int nextCol;
        int directionToPlace = 0;
        int[] cordinates = new int[2];

        switch(shipType){
            case DESTROYER:
                length = 2;
            case CRUISER:
                length = 3;
            default: length = 4;
        }
        int direction;

        while( !canPlaceShip ){
            direction = rand.nextInt(4);
            cordinates = generateRandomCordinates();
            
            if( !isValidLocation(cordinates[0], cordinates[1])) continue;
            int row = cordinates[0];
            int col = cordinates[1];

            for( int a = 1; a <= length; a++){
                nextRow = row + dx[direction] * a;
                nextCol = col + dy[direction] * a;
                if(!canPlaceShipSquare(nextRow, nextCol )) break;
                if( a == length){
                    canPlaceShip = true;
                    directionToPlace = direction;
                }
            }

        }
        //By now we can place the ship
        int rowStart = cordinates[0];
        int colStart = cordinates[1];

        for( int a = 1; a < length; a++){          //Does actual placing
            nextRow = rowStart + dx[directionToPlace] * a;
            nextCol = colStart + dy[directionToPlace] * a;
            hiddenShipsBoard[nextRow][nextCol] = true;   //Place square in hiddenShips board;

        }


    }
    
    private boolean canPlaceShipSquare(int nextRow, int nextCol){
        if( nextRow < 0 || nextRow >= boardLength || nextCol < 0 || nextCol >= boardWidth || hiddenShipsBoard[nextRow][nextCol]  ) return false;
        return true;

    }





    protected int[] generateRandomCordinates(){
        int[] result = new int[2];
        result[0] = rand.nextInt(boardLength);
        result[1] = rand.nextInt(boardWidth);
        

        return result;
    }

    protected boolean inBounds(int row, int col){
        if( row < 0 || row >= boardLength || col < 0 || col >= boardWidth) return false;
        return true;
    }

    public void printHiddenBoard(){
        for( var row : this.hiddenShipsBoard){
            for( var element: row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
};


/*
                Up,         Right,      Down,       Left
    [a][b]      [a-1][b]    [a][b+1]    [a+1][b]    [a][b-1]
    int[] dx = [-1,0,1,0];
    int[] dy = [0,1,0,-1];



*/