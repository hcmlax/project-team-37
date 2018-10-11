package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import static cs361.battleships.models.AtackStatus.*;

//import package to get random numbers
import java.util.Random;

public class Game {

    @JsonProperty private Board playersBoard = new Board();
    @JsonProperty private Board opponentsBoard = new Board();

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
        boolean successful = playersBoard.placeShip(ship, x, y, isVertical);
        if (!successful)
            return false;

        boolean opponentPlacedSuccessfully;
        do {
            // AI places random ships, so it might try and place overlapping ships
            // let it try until it gets it right
            opponentPlacedSuccessfully = opponentsBoard.placeShip(ship, randRow(), randCol(), randVertical());
        } while (!opponentPlacedSuccessfully);

        return true;
    }

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean attack(int x, char  y) {
        Result playerAttack = opponentsBoard.attack(x, y);
        if (playerAttack.getResult() == INVALID) {
            return false;
        }

        Result opponentAttackResult;
        do {
            // AI does random attacks, so it might attack the same spot twice
            // let it try until it gets it right
            opponentAttackResult = playersBoard.attack(randRow(), randCol());
        } while(opponentAttackResult.getResult() == INVALID);

        return true;
    }

    //get a random col from A-J
    public char randCol() {

        //create a string of the valid columns
        String validLetters = "ABCDEFGHIJ";

        //get the length of validLetters
        int strLen = validLetters.length();

        //create a random object to get an index from validLetters
        Random randNum = new Random();

        //get a random number and take the letter from that index
        char col = validLetters.charAt(randNum.nextInt(strLen));

        return col;
    }

    //get a random row from 1-10
    public int randRow() {

        //create random object to get a random number
        Random randNum = new Random();

        //use function from random class to get a number from 0-9
        int row = randNum.nextInt(10);

        //increment row so number is between 1-10
        row++;

        //return random value for row
        return row;
    }

    //get a random boolean value
    public boolean randVertical() {

        //create a random object
        Random randNum = new Random();

        //get a random number between 0 and 1
        int num = randNum.nextInt(2);

        //if number is 1, return true
        if(num == 1){
            return true;
        }
        //if number is 0, return false
        else {
            return false;
        }
    }
}
