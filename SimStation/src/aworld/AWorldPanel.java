package aworld;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import framework.AppPanel;
import simstation.Simulation;

public class AWorldPanel extends AppPanel {
	
	private AWorldControlPanel controlPanel;
	private SimView simView;
	private World world;
	
	public AWorldPanel(World world, ActionListener listener) {
		super(world, listener);
		this.world = world;
		setLayout(new GridLayout(1,2));
		controlPanel = new AWorldControlPanel(world, listener);
		simView = new SimView(world);
		this.add(controlPanel);
		this.add(simView);
	}
	
}