import java.util.Random;

public class Utilities {
	private static Random gen = new Random();
	
	Utilities(){
	}

	public static int nextInt(int bound) {
		return gen.nextInt(bound + 1);
	}
	
}
