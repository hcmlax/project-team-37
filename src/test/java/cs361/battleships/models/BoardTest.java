package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class BoardTest {

    @Test
    public void testInvalidPlacement() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 11, 'C', true));
        assertFalse(board.placeShip(new Ship("DESTROYER"), 9, 'C', true));
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 9, 'J', true));
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), 3, 'K', true));
    }

}
