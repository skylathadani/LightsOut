
import java.util.*;

public class ArrayListSolutionQueue implements SolutionQueue{

	private ArrayList <Solution> queue;
	

	public ArrayListSolutionQueue(){
		queue = new ArrayList <Solution> ();
		
	}

	public boolean isEmpty(){

		if(this.queue.size() != 0){
			return false;
		}

		return true;

	}

	public void enqueue(Solution value){
	this.queue.add(value);
	}

	public Solution dequeue(){

		Solution x = this.queue.get(0);

		this.queue.remove(0);

		return x;

	}

}