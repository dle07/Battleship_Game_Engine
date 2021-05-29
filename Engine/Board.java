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
    private int boardLength = 5;
    private int boardWidth = 5;
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,1,0,-1};

    protected static Random rand = new Random();

    public Board(int boardLength, int boardWidth){

        this.boardLength = boardLength;
        this.boardWidth = boardWidth;
        board = new ArrayList<> (boardLength);          
        visited = new boolean[boardLength][boardWidth];                                    // Initally set to false, no need to continue
        hiddenShipsBoard = new boolean[boardLength][boardWidth]; 

        
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
   

    public void generateRandomBoard(){
        for( Ships ship: Ships.values()){
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
        
        while( !canPlaceShip ){
            cordinates = generateRandomCordinates();
            if( !isValidLocation(cordinates[0], cordinates[1])) continue;
            int row = cordinates[0];
            int col = cordinates[1];

            for( int i = 0; i < 4; i++){

                for( int a = 1; a <= length; a++){
                    nextRow = row + dx[i] * a;
                    nextCol = col + dy[i] * a;
                    if(!canPlaceShipSquare(nextRow, nextCol )) break;
                    if( a == length){
                        canPlaceShip = true;
                        directionToPlace = i;
                    }
                }
                if( canPlaceShip )break;
            }
        }//By now we can place the ship
        int rowStart = cordinates[0];
        int colStart = cordinates[1];

        for( int a = 1; a <= length; a++){          //Does actual placing
            nextRow = rowStart + dx[directionToPlace] * a;
            nextCol = colStart + dy[directionToPlace] * a;
            hiddenShipsBoard[nextRow][nextCol] = true;   //Place square in hiddenShips board;

        }


    }
    
    private boolean canPlaceShipSquare(int nextRow, int nextCol){
        if( nextRow < 0 || nextRow >= boardLength || nextCol < 0 || nextCol >= boardWidth || hiddenShipsBoard[nextRow][nextCol]  ) return false;
        return true;

    }





    private int[] generateRandomCordinates(){
        int[] result = new int[2];
        result[0] = rand.nextInt(8);
        result[1] = rand.nextInt(8);
        

        return result;
    }

};


/*
                Up,         Right,      Down,       Left
    [a][b]      [a-1][b]    [a][b+1]    [a+1][b]    [a][b-1]
    int[] dx = [-1,0,1,0];
    int[] dy = [0,1,0,-1];



*/