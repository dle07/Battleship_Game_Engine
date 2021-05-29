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
        String temp = "hello";
        System.out.println(temp.toString());

        /*
        String example = "Hello there how are you";
        String[] temp;
        temp = example.split(" ");
        /*
        String temp = "gello";
        System.out.println(String.class);
        if(temp.getClass().equals(String.class)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        Object myObject = "Hello";
        System.out.println(myObject);
        var temp1 = myObject;
        System.out.println(temp1.getClass());
        /*
        Object[] myObjects = new Object[2];
        myObjects[0] = "Hello";
        myObjects[1] = 2;

        String temp = (String)(myObjects[0]);
        int tempInt = (int) myObjects[1];
        System.out.println(temp + "    " + tempInt);
        System.out.println(myObjects[0] + "    " + myObjects[1]);
        System.out.println(myObjects[0].getClass());
        System.out.println(myObjects[1].getClass());
        System.out.println(String.class);
        
        /*

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
