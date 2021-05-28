package Engine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    
    protected ArrayList<ArrayList<Integer>>    board;                  // This board represents the actual playing space.
    protected boolean[][]                      hiddenShipsBoard;            // Used to represent Where our ships are really hidden
    protected boolean[][]                      visited;                //

    protected static Random rand = new Random();
    int x;
    int y;

    public Board(int boardLength, int boardWidth){

        board = new ArrayList<> ();          

        visited = new boolean[boardLength][boardWidth];                                    // Initally set to false, no need to continue
        hiddenShipsBoard = new boolean[boardLength][boardWidth]; 

        
        for( int i = 0; i < 8; i++){
            ArrayList<Integer>   temp  =  new ArrayList<Integer>(Collections.nCopies(8, 0)); 
            System.out.println("Adding");
            Collections.fill(temp,  Integer.valueOf(0));
            for( var el: temp){
                System.out.println(el);
            }
            this.board.add(temp);
        }
        
    };

    protected boolean isValidLocation( int x, int y){
        //TODO....
        return false;
    }
   

    public void generateRandomBoard(){
        for( Ships ship: Ships.values()){
            this.placeShipRandomly(ship);
        }
    }

    private void placeShipRandomly(Ships shipType){
        
        boolean placed = false;
        int length;

        switch(shipType){
            case DESTROYER: length = 2;
            case CRUISER: length =3;
            default: length = 4;
        }
        
        while( !placed ){
            this.generateRandomCordinates();

        }
    }





    private void generateRandomCordinates(){
        this.x = rand.nextInt(8);
        this.y = rand.nextInt(8);
    }

};
