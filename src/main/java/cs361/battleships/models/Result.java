package cs361.battleships.models;
public class Result {
	private Ship ship;//The Result's related ship
	private AtackStatus AtackStatus;
	private Square Location;// The results location
	public AtackStatus getResult() {
		return this.AtackStatus;
	}

	public void setResult(AtackStatus result) {
		this.AtackStatus=result;
	}

	public Ship getShip() {//Return the ship information
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship=ship;
	}

	public Square getLocation() {
		return this.Location;
	}

	public void setLocation(Square square) {
		this.Location=square;
	}
}
