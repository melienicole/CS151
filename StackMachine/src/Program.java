import java.util.ArrayList;

public class Program {
	
	private ArrayList<Command> commands;
	
	public Program(){
		commands = new ArrayList<Command>();
	}
	
	public void execute() throws DivByZeroException, EmptyStackException, StackMachineException{
		for (Command cmmd: commands) {
			cmmd.execute();
		}
	}
	
	public void add(Command c) {
		commands.add(c);
	}


}
