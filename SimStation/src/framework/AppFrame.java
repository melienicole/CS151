package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import aworld.AWorldFactory;
import aworld.World;

public class AppFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 4552217060916272583L;
	protected AppFactory factory;
	protected Model model;
	protected JMenuBar menuBar;
	protected AppPanel panel;
	
	public AppFrame(AppFactory factory) {
		this.factory = factory;
		model = factory.makeModel();
		menuBar = createMenuBar();
		panel = factory.makeAppPanel(model, this);
		
		setTitle(factory.getTitle());
	}
	
	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = Utilities.makeMenu("File", new String[] {"New", "Open", "Save", "Save As", "Quit"}, this);
		JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
		JMenu helpMenu = Utilities.makeMenu("Help", new String[] {"About", "Contents"}, this);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = ((AbstractButton)e.getSource()).getText();
		switch(str) {
		case "New":
			if(Utilities.checkUnsavedChanges(model))
				model.copy(factory.makeModel());
			model.changed();
			break;
		case "Open":
			if(Utilities.checkUnsavedChanges(model))
				Utilities.loadModel(model);
			model.changed();
			break;
		case "Save":
			Utilities.saveModel(model);
			break;
		case "Save As":
			Utilities.saveModelAs(model);
			break;
		case "Quit":
			System.exit(NORMAL);
			break;
		case "About":
			Utilities.inform(factory.getAbout());
			break;
		case "Contents":
			Utilities.inform(factory.getContents());
			break;
		default:
			CommandProcessor.executeCommand(factory.stringToCommand(model, str));
		}
	}

	public Model getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	

}
