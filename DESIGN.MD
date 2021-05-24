Play space will be a 8x8 board.

Player Class
    ~ Representational 


Computer Based
Randomly




Game board
Example of a game board will look like

User                   Computer

0 1 2 3 4 5 6 7        1 2 3 4 5 6 7 8
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 1 
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 2
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 3
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 4
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 5
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 6
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 7
~ ~ ~ ~ ~ ~ ~ ~    |   ~ ~ ~ ~ ~ ~ ~ ~ 8




generateRandomBoard(Ships shipType);
This function will generate a random board.
Depending on the shipType, that's the length of the board.
1)Find a random unoccupied spot in the array.
2) Create a for loop that goes in 4 directions, up,left,right,down.
    ~ If there's a vacant spot we must continue in that direction until the ship length is achieved. 
    ~ If we can't place the whole ship, revert the board to its previous state, continue the loop.

3) If step 2 failed to place the ship, jump back to step 1.