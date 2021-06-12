package Engine;


public class ComputerPlayer extends Player{

    private int[] dx = {-1,0,1,0};              //up, right, down, left
    private int[] dy = {0,1,0,-1};
    boolean sucessfulStartHit = false;
    boolean continueDirection = false;
    boolean goOppositeDirection = false;
    int x;
    int y;
    int xPrev;
    int yPrev;
    int row_sucessful_hit_root;
    int col_sucessful_hit_root;
    
    int leadDirection;
    int ithDirection;

    ComputerPlayer(int row, int col){   
        super(row, col);
    }
    

    // Compupter shoot algorithm 
    void shoot(Player target){
        if( !sucessfulStartHit){            //pick random cordinate and guess if we havent found a piece of a ship

            do{
                int[] cords = this.player_board.generateRandomCordinates();
                x = cords[0];
                y = cords[1];
            }while(this.player_board.visited[x][y]);  //valid location to guess if the computer hasn't guessed this yet
            this.registerHit(x, y, target);

        }else{// Here we will either go off a lead or try and find a lead.

            
            if(goOppositeDirection){         //If we reach a end while going in the opposite direction we should set continueDirection and goOppositeDirection to false. There's also a case where the next x and y are out of bounds. This means we should set continueDirection and goOppositeDirection to false and call Shoot() again be

                this.updateNextCell();
                if( !Game.inBounds(x, y)){    // We've reached out of bounds, try a 
                    sucessfulStartHit = false;
                    goOppositeDirection = false;
                    continueDirection = false;
                    shoot(target);

                }else{
                    this.registerHit(x, y, target);
                }

            }
            else if( continueDirection)
            {
                this.updateNextCell();
                if(!Game.inBounds(x, y)){        // We reached a wall, stop and call shoot again
                    xPrev = row_sucessful_hit_root;
                    yPrev = col_sucessful_hit_root;
                    goOppositeDirection = true;
                    continueDirection = false;
                    this.switchDirection();
                    this.shoot(target);

                }else{
                    leadDirection = ithDirection;
                    this.registerHit(x, y, target);
                }

            }
            else
            {                             // We have to try and get a lead from up, right and down
 
                do{
                    x = row_sucessful_hit_root + dx[ithDirection];
                    y = col_sucessful_hit_root + dy[ithDirection];
                    ithDirection++;
                }while(!this.player_board.isValidLocation(x, y));

                if( sucessfulHit(x, y, target) )
                {
                    continueDirection = true;
                }

                if( ithDirection == 4){
                    ithDirection = 0;
                    if( !this.sucessfulHit(x, y, target)){
                        sucessfulStartHit = false;
                        shoot(target);

                    }
                }       

            }
        }
        

    };
    protected void updateNextCell(){
        x = xPrev + dx[leadDirection];
        y = yPrev + dy[leadDirection];
        xPrev = x;
        yPrev = y;
    }
    //up, right, down, left
    // 0  1      2     3
    protected void switchDirection(){
        switch(leadDirection){
            case 0: leadDirection = 2;   // If up, go switch to down
            case 1: leadDirection = 3;   // If right go switch to left 
            case 2: leadDirection = 0;   // If down go switch to up
            default: leadDirection = 1;  // If left switch to right
        }
    }
    protected void registerHit(int row, int col, Player target){
        this.player_board.visited[x][y] = true;
            if( this.sucessfulHit(x, y, target)){        // If it's a successful hit we need to register this

                target.player_board.board.get(x).set(y, 1);
                row_sucessful_hit_root = x;
                col_sucessful_hit_root = y;
                sucessfulStartHit = true;

            }else{
                target.player_board.board.get(x).set(y, -1);        // This was a unsucessful hit
            }
    }
    

};

/*computer shoot() logic

pick random cordinate
if it's a sucessful hit we will try top, left, right down. 
If any of those are sucessful, we should continue if we reach a end, out of bounds and we've only covered 2 squares, go in the opposite direction


*/