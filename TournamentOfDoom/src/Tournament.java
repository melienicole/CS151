
public class Tournament {

	public static void main(String[] args) {

		Gladiator sonya = new Gladiator("Sonya");
		Gladiator zena = new Gladiator("Zena");

		CompositeStrategy s1 = new CompositeStrategy();
		s1.add(new StabStrategy());
		s1.add(new StabStrategy());
		s1.add(new PoisonStrategy());
		sonya.setStrategy(s1);

		CompositeStrategy s2 = new CompositeStrategy();
		s2.add(new ShootStrategy());
		s2.add(new StabStrategy());
		s2.add(new PoisonStrategy());
		zena.setStrategy(s2);

		while(0 < zena.getHealth() && 0 < sonya.getHealth()) {
			zena.attack(sonya);
			sonya.attack(zena);
		}

		System.out.println("Results: ");
		if (zena.getHealth() > sonya.getHealth()) {
			System.out.println("Zena is the winner!");
		}
		else {
			System.out.println("Sonya is the winner!");
		}
		System.out.println(sonya.getName() + ": " + sonya);
		System.out.println(zena.getName() + ": " + zena);

	}

}
