package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Ship {
	private List<Square> OccuipiedSquares;
	private int ShipLen;

	public Ship(String kind) {
		OccupiedSquares=new ArrayList<Square>();//init the object of the square
		if(kind==""){

		}else if(kinds==""){

		}
		//Check the type of ship and Setting the length
	}

	public int getShipLen() {
		return ShipLen;
	}

	public List<Square> getOccupiedSquares() {
		return this.OccupiedSquares;
	}
}
