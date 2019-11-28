package aworld;

import java.io.Serializable;

import framework.Utilities;

enum Heading {
	NORTH, EAST, WEST, SOUTH; 
}

public abstract class Agent implements Serializable {
	
	protected World world;
	protected int xc;
	protected int yc;
	protected Heading heading;
	
	public Agent(World w) {
		this.world = w;
		xc = Utilities.randInt(0, world.SIZE-10);
		yc = Utilities.randInt(0, world.SIZE-10);
	}
	
	public void move(int steps) {
		if (heading == Heading.NORTH)  yc += steps;
		else if (heading == Heading.EAST) xc += steps;
		else if (heading == Heading.SOUTH) yc -= steps;
		else if (heading == Heading.WEST) xc -= steps;
		
		if (xc >= world.SIZE) xc = 0;
		if (yc >= world.SIZE) yc = 0;
		if (xc < 0) xc = world.SIZE;
		if (yc < 0) yc = world.SIZE;
		
		
	}
	
	public void turn(Heading heading) {
		this.heading = heading;
		
	}
	
	public int getXc() {
		return this.xc;
	}
	
	public int getYc() {
		return this.yc;
	}
	
	public abstract void update();
}
