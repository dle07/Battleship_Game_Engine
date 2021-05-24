package Engine;

import java.util.Random;

public class Board {
    protected Character[][] representation_board;     // This board will be the representational board
    protected int[][] actual_space;                   // This board represents the actual playing space.
    protected boolean[][] visited;                    // -1 ~ Represents missed hit

    Random rand;

    public Board(){
        rand = new Random();
    };


    public void generateRandomBoard(){

        for( Ships ship: Ships.values()){
            this.placeShipRandomly(ship);
        }
    
    }

    private void placeShipRandomly(Ships shipType){
        if(shipType == Ships.DESTROYER){                // length of 2

            
            
        }else if( shipType.equals(Ships.CRUISER)){      // length of 3




        }else{



        }
    }
};
