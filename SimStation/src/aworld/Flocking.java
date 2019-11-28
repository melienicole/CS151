package aworld;

import java.awt.Dimension;

import framework.AppFrame;

public class Flocking {
	
	public static void main(String[] args) {
		
		AWorldFactory worldFact = new AWorldFactory();
		AppFrame appFrame = new AppFrame(worldFact);
		
		World w = (World) appFrame.getModel();
		
		w.setSimulation("Flocking");
		
		appFrame.setMinimumSize(new Dimension(1000,500));
		
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
}