public interface Command {
	
	public abstract void execute() throws StackMachineException;
	
}
	
	class Push implements Command {
		private Double arg;
		
		public Push(Double arg) {
			this.arg = arg;
		}
		
		public void execute() {
			StackMachine.stack.push(this.arg);
		}
	}
	
	class Pop implements Command{
		public void execute() throws EmptyStackException{
			StackMachine.stack.pop();
		}
	}
	
	class Add implements Command {
		public void execute() throws EmptyStackException, StackTooShortException {
			if (StackMachine.stack.size() <= 1) {
				throw new StackTooShortException("Stack too short");
			}
			Double x = StackMachine.stack.pop();
			Double y = StackMachine.stack.pop();
			StackMachine.stack.push(x+y);
		}
	}
	
	class Mul implements Command {
		public void execute() throws EmptyStackException, StackTooShortException {
			if (StackMachine.stack.size() <= 1) {
				throw new StackTooShortException("Stack too short");
			}
			Double x = StackMachine.stack.pop();
			Double y = StackMachine.stack.pop();
			StackMachine.stack.push(x*y);
		}
	}
	
	class Sub implements Command {
		public void execute() throws EmptyStackException, StackTooShortException  {
			if (StackMachine.stack.size() <= 1) {
				throw new StackTooShortException("Stack too short");
			}
			Double x = StackMachine.stack.pop();
			Double y = StackMachine.stack.pop();
			StackMachine.stack.push(x-y);
		}
	}
	
	class Div{
		public void execute() throws DivByZeroException, EmptyStackException, StackTooShortException {
			if (StackMachine.stack.size() <= 1) {
				throw new StackTooShortException("Stack too short");
			}
			Double x = StackMachine.stack.pop();
			Double y = StackMachine.stack.pop();
			if (y == 0.0) {
				throw new DivByZeroException("Cannot div by zero");
			}
			StackMachine.stack.push(x/y);
		}
	}
		

