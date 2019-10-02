public class StackMachine {
	
	public static Stack<Double> stack = new Stack<Double>();;

	static void execute(Program p){
		try {
			stack.clear();
			p.execute();
			System.out.println("Stack = " + stack);
		}
		catch (EmptyStackException e) {
			System.out.println("Stack is empty");
		}
		catch (StackTooShortException e) {
			System.out.println(e.getMessage());
		}
		catch (DivByZeroException e) {
			System.out.println(e.getMessage());
		}
		catch (SyntaxErrorException e) {
			System.out.println(e.getMessage());
		}
		catch (StackMachineException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
