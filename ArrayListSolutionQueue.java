
import java.util.*;

public class ArrayListSolutionQueue implements SolutionQueue{

	private ArrayList <Solution> queue;
	

	public ArrayListSolutionQueue(){
		queue = new ArrayList <Solution> ();
		
	}

	public boolean isEmpty(){

		return queue.isEmpty();

	}

	public void enqueue(Solution value){
	this.queue.add(value);
	}

	public Solution dequeue(){

		Solution s = this.queue.get(0);

		this.queue.remove(s);

		return s;

	}

}