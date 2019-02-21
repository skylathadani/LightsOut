import java.util.*;
public class LightsOut{

	public static ArrayList <Solution> solve(int width,int height){
		long startTime = System.nanoTime();

		ArrayListSolutionQueue queue = new ArrayListSolutionQueue();

		ArrayList<Solution> solutions = new ArrayList<Solution>();

		Solution x = new Solution(width,height);

		queue.enqueue(x);


		while(!(queue.isEmpty())){

			Solution current = queue.dequeue();

			if(current.isReady() && current.isSuccessful()){
				long endTime   = System.nanoTime();
				long totalTime = (endTime - startTime)/1000;
				solutions.add(current);
				System.out.println("A Solution has been found in " + totalTime + " ns");
			}else if(current.isReady() == false){
				Solution temp = new Solution(current);

				current.setNext(true);
				temp.setNext(false);

				queue.enqueue(current);
				queue.enqueue(temp);
			}

		}

		return solutions;

	}

	public static void main(String[] args) {

		ArrayList<Solution> s = solve(3,2);

		System.out.println("There are " + s.size() + " solutions found");

		for(int i = 0;i<s.size(); i++){
			System.out.println("Solution " + (i+1) + ":");
			System.out.println(s.get(i));
		}
		
	}
	

	

	


}
