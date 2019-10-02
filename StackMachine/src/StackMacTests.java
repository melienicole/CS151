public class StackMacTests {

	// f() = 5x^2 - 3
	public static void test0(Double x) {
		// create an empty program
		Program p = new Program();
		// add commands to p:
		p.add(new Push(3.0));
		p.add(new Push(x));
		p.add(new Push(x));
		p.add(new Push(5.0));
		p.add(new Mul());
		p.add(new Mul());
		p.add(new Sub());
		// now execute
		StackMachine.execute(p);

	}

	//f(x) = x^3 + 3x^2 - 2x + 1
	public static void test1(Double x) {
		Program p2 = new Program();
		p2.add(new Push(1.0));
		p2.add(new Push(x));
		p2.add(new Push(2.0));
		p2.add(new Mul());
		p2.add(new Push(x));
		p2.add(new Push(x));
		p2.add(new Mul());
		p2.add(new Push(3.0));
		p2.add(new Mul());
		p2.add(new Push(x));
		p2.add(new Push(x));
		p2.add(new Mul());
		p2.add(new Push(x));
		p2.add(new Mul());
		p2.add(new Add());
		p2.add(new Sub());
		p2.add(new Add());
		
		StackMachine.execute(p2);
	}

	public static void main(String[] args) {
		System.out.println("Test 0 Results: ");
		test0(2.0); // [17.0]
		test0(4.0); // [77]
		
		System.out.println("Test 1 Results: ");
		test1(2.0); // [17.0]
		test1(5.0); // [191.0]
		
	}

}