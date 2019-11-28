package aworld;

import framework.Command;
import framework.Model;
import simstation.Simulation;

abstract class Status extends Command {
	
	protected Simulation sim;
	
	public Status(Model m) {
		super(m);
	}
	
	public void execute() {
		this.sim = (Simulation) model;
	}

}

class Resume extends Status {
	public Resume(Model m) {
		super(m);
	}
	
	public void execute() {
		sim.resume();
	}
}

class Start extends Status {
	public Start(Model m) {
		super(m);
	}
	
	public void execute() {
		sim.start();
	}
}

class Suspend extends Status {
	public Suspend(Model m) {
		super(m);
	}
	
	public void execute() {
		sim.suspend();
	}
}

class Run extends Status {
	public Run(Model m) {
		super(m);
	}
	public void execute() {
		sim.run();
	}
}

class Stop extends Status {
	public Stop(Model m) {
		super(m);
	}
	
	public void execute() {
		sim.stop();
	}
}



