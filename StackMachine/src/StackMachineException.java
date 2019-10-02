
public class StackMachineException extends Exception {
	
	public StackMachineException(String gripe) {
		super(gripe);
	}

}

class EmptyStackException extends StackMachineException {

	public EmptyStackException(String gripe) {
		super("Stack is empty!");
	}
}

class StackTooShortException extends StackMachineException {
	
	public StackTooShortException(String gripe) {
		super("Stack too short");
	}
}

class DivByZeroException extends StackMachineException {
	
	public DivByZeroException(String gripe) {
		super("Cannot divide by 0");
	}
}

class SyntaxErrorException extends StackMachineException {
	
	public SyntaxErrorException(String gripe) {
		super("Syntax error");
	}
}

