package aworld;

import java.awt.Dimension;

import framework.AppFactory;
import framework.AppFrame;

public class RandomWalk {
	
	public static void main(String[] args) {
		
		AWorldFactory worldFact = new AWorldFactory();
		AppFrame appFrame = new AppFrame(worldFact);
		
		World w = (World) appFrame.getModel();
		
		w.setSimulation("RandomWalk");
		
		appFrame.setMinimumSize(new Dimension(1000,500));
		
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
}