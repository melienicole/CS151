
public class Adapter extends Strategy {
	
	private SpitFire adaptee;
	
	public Adapter(Gladiator owner) {
		this.owner = owner;
	}
	
	public Adapter() {
		super();
	}
	
	public void setAdaptee(SpitFire adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void strike(Gladiator other) {
		this.adaptee.fight(this.owner,other);
	}

}
