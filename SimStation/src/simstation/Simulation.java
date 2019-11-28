package simstation;

import framework.Model;

enum SimState{
	READY, SUSPENDED, STOPPED, RUNNING;
}

public abstract class Simulation extends Model implements Runnable {

	protected String name;
	protected Long clock = 0L;
	protected SimState state = SimState.READY;
	// when it is time to save a simulation, skip the thread = transient
	transient protected Thread thread;
	
	public Simulation() {
		thread = new Thread(this);
	}

	public void run() {
		while (state == SimState.RUNNING) {
			update ();
			clock++;
			changed();
		}
		
		try {
			Thread.sleep(100);
			synchronized(this) {
				while(state == SimState.SUSPENDED) {
					wait();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		if (state == SimState.READY) {
			state = SimState.RUNNING;
			thread.start();
		}
		
	}
	
	public void stop() {
		if (state == SimState.SUSPENDED || state == SimState.RUNNING ) {
			state = SimState.STOPPED;
			thread.stop();
		}
		
	}
	
	public void suspend() {
		if (state == SimState.RUNNING ) {
			state = SimState.SUSPENDED;
			thread.suspend();
		}
		
	}
	
	public void resume() {
		if (state == SimState.SUSPENDED) {
			state = SimState.RUNNING;
			thread.resume();
		}
		
	}
	
	public Long getClock() {
		return this.clock;
	}
	
	abstract public void update();
	
}
