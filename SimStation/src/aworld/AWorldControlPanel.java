package aworld;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import framework.AppPanel;
import framework.Model;
import simstation.Simulation;

public class AWorldControlPanel extends JPanel implements Observer {
	
	private World world;
	private ActionListener listener;
	private JLabel clockLabel;
	private JLabel clockTime;
	private JButton startButton, suspendButton, resumeButton, stopButton;
	
	
	
	public AWorldControlPanel(Simulation model, ActionListener listener) {
		
		this.world = (World) model;
		this.listener = listener;
		setLayout(new GridLayout(4,1));
		
		clockLabel = new JLabel("clock ");
		clockTime = new JLabel("" + world.getClock());
		startButton = new JButton("start");
		suspendButton = new JButton("suspend");
		resumeButton = new JButton("resume");
		stopButton = new JButton("stop");
		startButton.addActionListener(listener);
		suspendButton.addActionListener(listener);
		resumeButton.addActionListener(listener);
		stopButton.addActionListener(listener);
		
		//clock labels
		JPanel p = new JPanel();
		p.add(clockLabel);
		p.add(clockTime);
		this.add(p);
		
		p = new JPanel();
		add(startButton);
		this.add(p);
		
		p = new JPanel();
		add(suspendButton);
		this.add(p);
		
		p = new JPanel();
		add(resumeButton);
		this.add(p);
		
		p = new JPanel();
		add(stopButton);
		this.add(p);
		
	}
	
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation) {
			clockLabel.setText("" + world.getClock());
			
		}
	}
	
	

}
