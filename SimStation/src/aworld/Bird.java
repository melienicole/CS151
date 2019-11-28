package aworld;

import framework.Utilities;

public class Bird extends Agent {
	// create two mains
	// one for random walks 
	// one for flocking
	// 50 birds / drunks

	private int speed;
	
	public Bird (World w) {
		super(w);
		
		speed = Utilities.randInt(1,5);
		turn(Heading.values()[Utilities.randInt(0, Heading.values().length)]);
		
	}
	
	public void update() {
		move(speed);
		Bird b = (Bird) world.findNeighbor(this, 1);
		
		if (b != null) {
			this.speed = b.getSpeed();
			this.heading = b.heading;
		}
	}

	private int getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}
}
