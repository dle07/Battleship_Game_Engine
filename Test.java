import java.util.Random;

import Engine.*;

public class Test {
    public enum Ships{
        DESTROYER,
        CRUISER,
        BATTLESHIP
    };
    public static void main( String[] args){
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
