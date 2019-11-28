package aworld;

import framework.Utilities;

public class Drunk extends Agent {
	
	private int speed = 10;
	protected World world;
	
	public Drunk(World w) {
		super(w);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		int steps = Utilities.randInt(1, speed);
		Heading randomHeader = Heading.values()[Utilities.randInt(0, Heading.values().length)];
		
		turn(randomHeader);
		move(steps);
	}
	
	
}
