import java.util.ArrayList;

public abstract class Strategy {
	
	protected Gladiator owner;
	abstract public void strike(Gladiator other);
	
	public void setOwner(Gladiator owner) {
		this.owner = owner;
	}
	
	protected void dmgHealth(Gladiator victim) {
		int damage = Utilities.nextInt(victim.getHealth());
		victim.dmgHealth(damage);
	}
	
}

	class StabStrategy extends Strategy{
		
		StabStrategy(Gladiator owner){
			this.owner = owner;
		}
		
		StabStrategy(){
		}
		
		public void strike(Gladiator other){
			System.out.println(owner.getName() + " stabs " + other.getName());
			//System.out.println("Stab has been used on " + other.getName());
			this.dmgHealth(other);
		}
	}
	
	class ShootStrategy extends Strategy {
		
		ShootStrategy(Gladiator owner){
			this.owner = owner;
		}
		
		ShootStrategy(){
		}
		
		public void strike(Gladiator other){
			System.out.println(this.owner.getName() + " shoots " + other.getName());
			//System.out.println("Shoot has been used on " + other.getName());
			this.dmgHealth(other);
		}
	}
	
	class PoisonStrategy extends Strategy{
		
		PoisonStrategy(Gladiator owner){
			this.owner = owner;
		}
		
		PoisonStrategy(){
		}
		
		public void strike(Gladiator other){
			System.out.println(owner.getName() + " poisons " + other.getName());
			//System.out.println("Poison has been used on " + other.getName());
			this.dmgHealth(other);
		}
	}
	
	class SpitFire {
		public void fight(Gladiator attacker, Gladiator victim) {
	    System.out.println(attacker.getName() + " is spitting fire at " + victim.getName());
	  }
	}
	
	class CompositeStrategy extends Strategy {
		
		private ArrayList<Strategy> children;
		
		CompositeStrategy(){
			children = new ArrayList<Strategy>();
		}
		
		public void add(Strategy s) { 
			children.add(s);
		}
		
		public void setOwner(Gladiator owner) {
			for (Strategy s: children) {
				s.setOwner(owner);
			}
		}
		
		public void strike(Gladiator other) {
			for (Strategy s: children){
				s.strike(other);
			}
		}

	}
		
		

