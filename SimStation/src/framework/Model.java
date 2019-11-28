package framework;

import java.io.Serializable;
import java.util.Observable;

/**
 * Represents a generic Model for any given application.
 * 
 * A Model is Observable so that it can notify Observers in higher packages that
 * a change was made to the data on the Model.
 * 
 * A Model is Serializable so that it can be saved in a binary format to disk
 * and retrieved whenever as a Java object.
 */
public abstract class Model extends Observable implements Serializable {
	private static final long serialVersionUID = 448387068664163242L;
	
	protected String filepath;
	protected String filename;
	protected boolean unsavedChanges;
	
	/**
	 * Constructs a Model given a filename beforehand.
	 */
	public Model(String filepath) {
		this.filepath = filepath;
		unsavedChanges = false;
	}

	
	/**
	 * Constructs a Model with nothing.
	 */
	public Model() {
		this(null);
	}

	public String getFilepath() { 
		return filepath; 
	}
	public void setFilepath(String filename) { 
		this.filepath = filename; 
	}
	
	public boolean isUnsavedChanges() { 
		return unsavedChanges; 
	}
	public void setUnsavedChanges(boolean unsavedChanges) { 
		this.unsavedChanges = unsavedChanges; 
	}
	
	/**
	 * Called any time this Model's data has changed.
	 * 
	 * If the model has changed:
	 * - The Model is now different from the save file, so changes must be unsaved
	 * - All Observers need to be notified of changes
	 */
	public void changed() {
		setUnsavedChanges(true);
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	/**
	 * Makes this Model a copy of the given Model m.
	 * 
	 * For a subclass of Model this method most certainly needs to be rewritten to
	 * account for any additional attributes that need to be copied.
	 */
	public void copy(Model m) {
		this.filepath = m.getFilepath();
		this.unsavedChanges = m.isUnsavedChanges();
		changed();
	}


	public String getFileName() {
		return filename;
	}


	public void setFileName(String fName) {
		this.filename = fName;
	}
}
