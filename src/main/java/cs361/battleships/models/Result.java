package cs361.battleships.models;
public class Result {
	private Ship ship;//The Result's related ship
	private AtackStatus atackStatus;
	private Square location;// The results location
	public AtackStatus getResult() {
		return this.atackStatus;
	}

	public void setResult(AtackStatus result) {
		this.atackStatus=result;
	}

	public Ship getShip() {//Return the ship information
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship=ship;
	}

	public Square getLocation() {
		return this.location;
	}

	public void setLocation(Square square) {
		this.location=square;
	}
}
