package aworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;

import javax.swing.BorderFactory;

import framework.Model;
import framework.View;
import simstation.Simulation;

public class SimView extends View {

	public SimView(Model model) {
		// TODO Auto-generated constructor stub
		super(model);
		
		World w = (World) model;
		
		setSize(new Dimension(w.SIZE,w.SIZE));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, false));
		
	}
	
	@Override
	public void update(Observable subject, Object msg) {
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics gc) {
		Graphics2D graphic2d = (Graphics2D)gc;
		
		World sim = (World)model;
		
		for (Agent a: sim.getAgents()) {
			AgentDisplay agentDisp = new AgentDisplay((double)a.getXc(),
											(double)a.getYc(), 10.0, 10.0);
			agentDisp.draw(graphic2d);
		}
		
	}
	
	class AgentDisplay {
		private Rectangle2D.Double agent;
		
		public AgentDisplay(Double xc, Double yc, Double w, Double h) {
			agent = new Rectangle2D.Double(xc+.3*w, yc+.3*h, .4*w, .4*h);
		}
		
		public void draw(Graphics2D gc) {
			Color oldColor = gc.getColor();
			gc.setColor(Color.red);
			gc.fill(agent);
			gc.setColor(oldColor);
		}
	}
}
	