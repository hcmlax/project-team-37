package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Ship {
	private List<Square> occuipiedSquares;
	private int shipLen;

	public Ship() {
		occuipiedSquares = new ArrayList<>();
	}

	public Ship(String kind) {
		occuipiedSquares=new ArrayList<Square>();//init the object of the square
		if(kind.equals("BATTLESHIP")){
			this.shipLen=4;
		}else if(kind.equals("DESTROYER")){
			this.shipLen=3;
		}else {
			this.shipLen=2;
		}
		//Check the type of ship and Setting the length
	}

	public int getShipLen() {
		return this.shipLen;
	}

	public List<Square> getOccupiedSquares() {
		return this.occuipiedSquares;
	}
}
