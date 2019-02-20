import java.util.*;
public class LightsOut{
	public static ArrayList<Solution> solve(int width, int height){
		final long startTime = System.nanoTime();
		ArrayListSolutionQueue partialSolutions = new ArrayListSolutionQueue();
		Solution x = new Solution(width,height);
		partialSolutions.enqueue(x);
		ArrayList <Solution> solutions = new ArrayList <Solution> ();

		while(!(partialSolutions.isEmpty())){
			Solution current = partialSolutions.dequeue();
			System.out.println(current);

			if(current.isReady()){
				if(current.isSuccessful()){
					solutions.add(current);
				final long duration = System.nanoTime() - startTime;

				System.out.println("A solution has been found in " + duration);

				}
				
			}else if (current.isReady() == false){

				Solution temp = new Solution(current);

				current.setNext(true);
				temp.setNext(false);

				partialSolutions.enqueue(current);
				partialSolutions.enqueue(temp);

			}
		}

		return solutions;
	}

	public static void main(String[] args) {

		ArrayList<Solution> solver = new ArrayList<Solution>();

		solver = solve(2,2);





		System.out.println("The number of solutions found is " + solver.size());

		System.out.println("The Solutions are:");

		for(int i = 0; i < solver.size(); i++){
			System.out.println(solver.get(i));
		}
	}
}
