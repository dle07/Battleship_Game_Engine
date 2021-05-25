import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
//import Engine.*;

public class Test {
    public enum Ships{
        DESTROYER,
        CRUISER,
        BATTLESHIP
    };
    public static void main( String[] args){

        ArrayList<ArrayList<Integer>>    board;
        board = new ArrayList<ArrayList<Integer>>(8);
        
        
        for( int i = 0; i < 8; i++){
            ArrayList<Integer>   temp  =  new ArrayList<Integer>(8); 
            Collections.fill(temp, 0);
            board.add(i, temp);
        }
        /*
        for( var el :  board){
            for( var elem: el){
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        /*
        System.out.println(Math.random());  
        Random rand = new Random();
        System.out.print(rand.nextInt());

        /*
        Game newGame =  new Game();
        newGame.printGameState();
        /*
        Ships curr = Ships.DESTROYER;
        if( curr.equals(Ships.DESTROYER)){
            System.out.println("Yes ");
        }else{System.out.println("No");}
        */


    };
}
