package framework;

import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.*;

public class Utilities {
	private final static boolean DEBUG = false;
	private static Random random = new Random();
	
	/**
	 * Returns a random int that is between min (inclusive) and max (exclusive).
	 */
	public static int nextInt(int min, int max) {
		return (int)(random.nextFloat() * (max - min) + min);
	}
	
	/**
	 * Return the distance between the point (ax, ay) and (bx, by).
	 */
	public static double distance(double ax, double ay, double bx, double by) {
		return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
	}
	
	/**
	 * Takes any object which implements the Serializable interface and
	 * writes it to the file located according the String filepath.
	 */
	public static void writeSerializableToFile(Serializable obj, String filepath) {
		try {
			FileOutputStream f = new FileOutputStream(new File(filepath));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(obj);
			
			o.close();
			f.close();
		} catch (Exception e) {
			error(e);
		}
	}
	
	/**
	 * Reads the serial data at String filepath and converts the data into
	 * an Object, which is returned.
	 */
	public static Object readFileToObject(String filepath) {
		Object obj = null;
		try {
			FileInputStream f = new FileInputStream(new File(filepath));
			ObjectInputStream o = new ObjectInputStream(f);
			
			obj = o.readObject();
			
			o.close();
			f.close();
		} catch (Exception e) {
			error(e);
		}
		return obj;
	}
	
	/**
	 * Asks the user for a file path first, then saves the Model.
	 */
	public static void saveModelAs(Model model) {
		// Show the user a file chooser to get a file path.
		String filepath = showFileChooser(model.getFilepath(), "Save File");
		/*
		 *  If the model didn't have a file path and somehow still doesn't,
		 *  the user has failed to specify a file path properly, so quit.
		 */
		if(filepath == null) return;
		// Set that file path, write to a file, tell model that it's saved.
		model.setFilepath(filepath);
		Utilities.writeSerializableToFile(model, model.getFilepath());
		model.setUnsavedChanges(false);
	}
	
	/**
	 * Saves the given Model to a binary file.
	 * This is possible because the Model is Serializable.
	 */
	public static void saveModel(Model model) {
		// First, make sure the model actually has a file path.
		if(model.getFilepath() != null) {
			// Write the model to its file path, tell model that it's saved.
			Utilities.writeSerializableToFile(model, model.getFilepath());
			model.setUnsavedChanges(false);
		} else {
			// No file path? Switch to a save as operation.
			saveModelAs(model);
		}
	}
	
	/**
	 * Loads a Model from a file, making the given Model a copy of that new Model.
	 */
	public static void loadModel(Model model) {
		// Show the user a file chooser to get a file path.
		String filepath = showFileChooser(model.getFilepath(), "Load File");
		/*
		 *  If there's still no file path, the user failed to specify it
		 *  correctly, so quit.
		 */
		if(filepath == null) return;
		// Read a Model object from this file path, this Model copies this incoming
		// Model and we tell the model that it's saved.
		Model newModel = (Model)Utilities.readFileToObject(filepath);
		model.copy(newModel);
		model.setUnsavedChanges(false);
	}
	
	/* 
	 * A bunch of GUI utility functions for quick pop-ups.
	 **/
	public static String ask(String message) {
		return JOptionPane.showInputDialog(
				null,
				message,
				JOptionPane.QUESTION_MESSAGE);
	}
	
	public static void error(Exception e) {
		if(DEBUG) e.printStackTrace();
		error(e.getMessage());
	}
	
	public static void error(String message) {
		JOptionPane.showMessageDialog(
				null, 
				message,
				"ERROR", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void inform(String message) {
		JOptionPane.showMessageDialog(
				null, 
				message,
				"INFO",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void inform(String[] messages) {
		String message = String.join("\n\n", messages);
		inform(message);
	}
	
	public static int confirm(String message) {
		return JOptionPane.showConfirmDialog(
				null, 
				message,
				"CONFIRM?",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * Checks if the model has unsaved changes and asks about saving before
	 * continuing with the operation.
	 * 
	 * Returns a boolean that is true if the user wants to proceed, and false otherwise.
	 */
	public static boolean checkUnsavedChanges(Model model) {
		if(model.isUnsavedChanges()) {
			int result = confirm("You have unsaved changes.\n\nWould you like to save?");
			if(result == JOptionPane.YES_OPTION) {
				saveModel(model);
			} else if(result == JOptionPane.CANCEL_OPTION) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Creates and returns a JMenu called name and with a list of JMenuItems according to
	 * the String array items. Every item is listened to by the ActionListener listener.
	 */
	public static JMenu makeMenu(String name, String[] items, ActionListener listener) {
		JMenu menu = new JMenu(name);
		for(String item : items) {
			JMenuItem newItem = new JMenuItem(item);
			newItem.addActionListener(listener);
			menu.add(newItem);
		}
		return menu;
	}
	
	/**
	 * Displays a JFileChooser and returns the file path of the file chosen
	 * by the user.
	 * 
	 * defaultFilepath is the file path that is defaulted to if the chooser
	 * fails.
	 */
	public static String showFileChooser(String defaultFilepath, String approveText) {
		JFileChooser fc = new JFileChooser();
		// start the file chooser in the user's home directory
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fc.showDialog(null, approveText);
		String filepath = defaultFilepath;
		if(result == JFileChooser.APPROVE_OPTION) {
			filepath = fc.getSelectedFile().toString();
		}
		return filepath;
	}
	
	/**
	 * Shorthand function for printing to the console.
	 * Simply prints the toString of the given Object o on a new console line.
	 */
	public static void sop(Object o) {
		System.out.println(o.toString());
	}

	public static int randInt(int i, int j) {
		// TODO Auto-generated method stub
		return random.nextInt(j-i)+i;
	}
}
