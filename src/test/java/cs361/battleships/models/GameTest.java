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

    @Test
    public void testgameplaceship(){
        Game game= new Game();
        Ship ship1= new Ship("MINSWEEPER");
        game.placeShip(ship1,5,'G',false);
        //boolean captured=game.playersBoard.Checkifused(new Square(5,'G'));
        //assertTrue(captured);
    }

    @Test
    public void testgameprocess(){
        Game game= new Game();
        Ship ship1= new Ship("MINESWEEPER");
        Ship ship2= new Ship("DESTROYER");
        Ship ship3= new Ship("BATTLESHIP");
        game.placeShip(ship1,8,'H',true);
        game.placeShip(ship2,9,'C',false);
        game.placeShip(ship3,10,'F',false);
        boolean attackresult=game.attack(5,'c');
        assertTrue(attackresult);
    }
}

