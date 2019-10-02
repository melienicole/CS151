public class Gladiator {
	
	private String name;
	private int health = 100;
	private Strategy strategy;
	
	public Gladiator(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if (health >= 0 && health <= 100) 
			this.health = health;
	}
	
	public void setStrategy(CompositeStrategy s) {
		this.strategy = s;
		s.setOwner(this);
	}
	
	public void dmgHealth(int damage) {
		if (health > 0) {
			health = Math.max(health - damage, 0);
		}
	}
	
	
	public void attack(Gladiator other){
		if (health > 0 && other.getHealth() > 0) {
			strategy.strike(other);
			System.out.println(other.getName() + "'s health = " + other.getHealth());
		}
	}

}

