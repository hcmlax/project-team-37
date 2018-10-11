package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

//NOTE: to run these tests, the functions in Game must be set to public
public class GameTest {

    @Test
    //test if randRow is returning valid numbers
    public void testRandRow() {
        Game game = new Game();
        assertTrue(game.randRow() < 11 && game.randRow() > 0);
    }

    @Test
    //test if randCol is returning valid chars
    public void testRandCol() {
        Game game = new Game();
        //get a random char
        char randCol = game.randCol();
        //convert char to ascii value
        int colVal = randCol;
        //check if ascii value is between A-J
        assertTrue(colVal > 64 && colVal < 75);
    }

    @Test
    //test if randVertical is returning a valid output
    public void testRandVertical() {
        Game game = new Game();
        boolean randBool = game.randVertical();
        //this should fail 50% of the time
        assert(randBool);
    }
}

