import java.util.ArrayList;

public class Stack <T> {
	
	private ArrayList<T> stack;

	public Stack() {
		stack = new ArrayList<T>();
	}
	
	public void push(T elems) {
		stack.add(elems);
	}
	
	public T pop() throws EmptyStackException {
		if (stack.size() == 0) {
			throw new EmptyStackException("Empty stack");
		}
		return stack.remove(stack.size()-1);
	}
	
	public T top() throws EmptyStackException {
		if (stack.size() == 0)
			throw new EmptyStackException("Empty stack");
		return stack.get(stack.size()-1);
	}
	
	public void clear() {
		stack.removeAll(stack);
	}
	
	public String toString() {
		return stack.toString();
	}
	
	public int size() {
		return stack.size();
	}

}


