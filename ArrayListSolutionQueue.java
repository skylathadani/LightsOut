
import java.util.*;

public class ArrayListSolutionQueue<Solution> implements SolutionQueue <Solution>{

	private ArrayList <Solution> queue;
	

	public ArrayListSolutionQueue(){
		queue = new ArrayList <Solution> ();
		
	}

	public boolean isEmpty(){

		return queue.isEmpty();

	}

	public void enqueue(Solution value){
		queue.add(value);
	}

	public Solution dequeue(){

		Solution s = queue.get(0);

		queue.remove(0);

		return s;

	}

}