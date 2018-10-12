package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Ship {
	private List<Square> OccuipiedSquares;
	private int ShipLen;

	public Ship(String kind) {
		OccuipiedSquares=new ArrayList<Square>();//init the object of the square
		if(kind=="BATTLESHIP"){
			this.ShipLen=4;
		}else if(kind=="DESTROYER"){
			this.ShipLen=3;
		}else {
			this.ShipLen=2;
		}
		//Check the type of ship and Setting the length
	}

	public int getShipLen() {
		return ShipLen;
	}

	public List<Square> getOccupiedSquares() {
		return this.OccuipiedSquares;
	}
}
