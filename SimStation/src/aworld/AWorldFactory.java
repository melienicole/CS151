package aworld;

import java.awt.event.ActionListener;

import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;

public class AWorldFactory implements AppFactory {
	
	public AWorldFactory() {
		
	}

	@Override
	public Model makeModel() {
		// TODO Auto-generated method stub
		Model newWorld = new World();
		return newWorld;
	}

	@Override
	public AppPanel makeAppPanel(Model model, ActionListener listener) {
		// TODO Auto-generated method stub
		if (model instanceof World) {
			return new AWorldPanel((World)model, listener);
		}
		return null;
	}

	@Override
	public Command stringToCommand(Model model, String str) {
		// TODO Auto-generated method stub
		Command newCommand = null;
		switch(str) {
		case "Stop":
			newCommand = new Stop(model);
		case "Start":
			newCommand = new Start(model);
		case "Resume":
			newCommand = new Resume(model);
		case "Suspend":
			newCommand = new Suspend(model);
		}
		return newCommand;
			
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Sim Station";
	}

	@Override
	public String[] getAbout() {
		// TODO Auto-generated method stub
		return new String[] {"Sim Station version 1.0", "Melie Herrera", "Pearce CS 151"};
	}

	@Override
	public String[] getContents() {
		// TODO Auto-generated method stub
		return new String[] {"Simulate a population of agents moving within", "an environment and interacting with random neighbors"};
	}

	@Override
	public String[] getEditCommands() {
		// TODO Auto-generated method stub
		return new String[] {"Start", "Stop", "Suspend","Resume"};
	}
	
	

}
