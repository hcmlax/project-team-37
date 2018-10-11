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
		this.BoardSizeX=10;
		this.BoardsizeY=10;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */

	public boolean Checkifused(Square Locate){
		for(int i=0;i<this.Ships.size();i++){
			for(int j=0;j<this.Ships.get(i).getOccupiedSquares().size();j++){
				char TempY=this.Ships.get(i).getOccupiedSquares().get(j).getColumn();
				int TempX=this.Ships.get(i).getOccupiedSquares().get(j).getRow();//get the temp them check
				if(TempY==Locate.getColumn() && TempX==Locate.getRow()){
					return true;
				}
			}
		}
		return false;
	}

	public boolean ifsink(Ship shipc){
		int hits=0;//COunt the hit
			for(int j=0;j<attacks.size();j++){
				if(attacks.get(j).getShip()==shipc){
					hits++;
				}
			}
		if(hits==shipc.getShipLen()){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		int length=ship.getShipLen();
		String validLetters = "ABCDEFGHIJ";
		if(isVertical){
			int temp=validLetters.indexOf(y);
			if(temp+length-1<BoardsizeY){
				for(int i=0;i<length;i++){
					Square Sq=new Square(x,validLetters.charAt(temp+i));
					Sq.setRow(x);
					Sq.setColumn(validLetters.charAt(temp+i));
					if(this.Checkifused(Sq)){//CHeck if it cover
						ship.getOccupiedSquares().add(Sq);
					}
					else {
						return false;
					}
				}
			}else{
				return false;//out bound!
			}
		}else{
			if(x+length-1<BoardSizeX){
				for(int i=0;i<length;i++){
					Square Sq=new Square((x+i),y);
					Sq.setRow(x+i);
					Sq.setColumn(y);
					if(this.Checkifused(Sq)){//CHeck if it cover
						ship.getOccupiedSquares().add(Sq);
					}
					else {
						return false;
					}
				}

			}else{
				return false;//out bound!
			}
		}
		this.Ships.add(ship);//add ship into the list
		return true;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Result Temp=new Result();
		int HitedNum=0;
		for(int i=0;i<this.Ships.size();i++) {//check if ship on the attack
			for(int j=0;j<this.Ships.get(i).getOccupiedSquares().size();j++){
				if(this.Ships.get(j).getOccupiedSquares().get(j).getRow()==x && this.Ships.get(j).getOccupiedSquares().get(j).getColumn()==y){//if it is hited
					Temp.setResult(AtackStatus.HIT);
					Square Location=new Square(x,y);
					Temp.setLocation(Location);
					Temp.setShip(this.Ships.get(i));
				}else{//if Miss
					Temp.setResult(AtackStatus.MISS);
					Square Location=new Square(x,y);
					Temp.setLocation(Location);
				}
			}
		}
		this.attacks.add(Temp);//add to the list
		if(this.ifsink(Temp.getShip())){//if boat sunk
			Temp.setResult(AtackStatus.SUNK);
			Ships.remove(Temp.getShip());
		}
		if(this.Ships.isEmpty()){
			Temp.setResult(AtackStatus.SURRENDER);
		}
		return Temp;
	}

	public List<Ship> getShips() {
		return this.Ships;
	}

	public void setShips(List<Ship> ships) {
		this.Ships=ships;
	}

	public List<Result> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Result> attacks) {
		this.attacks=attacks;
	}
}
