package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	private List<Ship> Ships;
	private List<Result> attacks;
	private int BoardSizeX;
	private int BoardsizeY;
	public Board() {

	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		int length=ship.Shiplen;
		if(isVertical){
			if()
		}else{

		}
		return false;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Result Temp=new Result();
		for(int i=0;i<this.Ships.size();i++){//check if ship on the attack
			if
		}
		attacks.add
		return Temp;
	}

	public List<Ship> getShips() {
		return this.Ships;
	}

	public void setShips(List<Ship> ships) {
		this.Ships=ships;
	}

	public List<Result> getAttacks() {
		//TODO implement
		return this.attacks;
	}

	public void setAttacks(List<Result> attacks) {
		this.attacks=attacks;
	}
}
