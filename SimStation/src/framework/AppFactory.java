package framework;

import java.awt.event.ActionListener;

public interface AppFactory {
	
	public Model makeModel();
	
	public AppPanel makeAppPanel(Model model, ActionListener listener);
	
	public Command stringToCommand(Model model, String str);
	
	public String getTitle();
	
	public String[] getAbout();

	public String[] getContents();

	public String[] getEditCommands();


}
