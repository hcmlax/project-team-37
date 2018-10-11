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
		int length=ship.getShipLen();
		String validLetters = "ABCDEFGHIJ";
		if(isVertical){
			int temp=validLetters.indexOf(y);
			if(temp+length-1<BoardsizeY){
				for(int i=0;i<length;i++){
					Square Sq=new Square(x,validLetters.charAt(temp+i));
					Sq.setRow(x);
					Sq.setColumn(validLetters.charAt(temp+i));
					ship.getOccupiedSquares().add(Sq);
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
					ship.getOccupiedSquares().add(Sq);//Add to the SHips OccupiedSquares
				}

			}else{
				return false;//out bound!
			}
		}
		return false;
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
					AtackStatus atk=AtackStatus.HIT;
					Temp.setResult(atk);
					Square Location=new Square();
					Location.setColumn(y);
					Location.setRow(x);
					Temp.setLocation(Location);
					Temp.setShip(this.Ships.get(i));
				}else{//if Miss
					AtackStatus atk=AtackStatus.MISS;
					Temp.setResult(atk);
					Square Location=new Square();
					Location.setColumn(y);
					Location.setRow(x);
					Temp.setLocation(Location);
				}
			}
		}
		this.attacks.add(Temp);//add to the list
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
