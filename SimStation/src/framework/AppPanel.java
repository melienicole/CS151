package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JPanel;

public class AppPanel extends JPanel implements ActionListener{
	
	protected Model model;
	protected ActionListener listener;
	protected Set<View> views;
	
	public AppPanel(Model model, ActionListener listener) {
		views = new HashSet<View>();
		this.model = model;
		this.listener = listener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public void update(Observable subject, Object o) {
		
	}
	
	public void add(View view) {
		super.add(view);
		views.add(view);
	}

}
