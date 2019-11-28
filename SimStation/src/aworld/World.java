package aworld;

import java.util.ArrayList;

import simstation.Simulation;

public class World extends Simulation {
	
	public int SIZE = 300;
	private ArrayList<Agent> agents;
	private String name = "RandomWalk";
	
	public World() {
		super();
		agents = new ArrayList<Agent>();
	}
	
	
	public void update()
	{
		for (Agent a: agents) {
			a.update();
		}

	}
	
	public void setSimulation(String str) {
		agents.clear();
		if (str == "RandomWalk") {
			for (int i = 0; i <= SIZE ; i++) {
				agents.add(new Drunk(this));
			}
		}
		else if (str == "Flocking" ) {
			for (int i = 0; i <= SIZE; i++) {
				agents.add(new Bird(this));
			}
		}
	}
	
	public Agent findNeighbor(Agent seeker, int radius) {
		return null;
	}


	public ArrayList<Agent> getAgents() {
		// TODO Auto-generated method stub
		return agents;
	}
}  
