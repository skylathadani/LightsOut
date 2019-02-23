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
				long totalTime = (endTime - startTime)/10000000;
				solutions.add(current);
				System.out.println("A Solution has been found in " + totalTime + " ms");
			}else if(current.isReady() == false){
				Solution temp = new Solution(current);

				//if(current.stillPossible(true) == true) {
					current.setNext(true);
					queue.enqueue(current);
				//}
				//if(temp.stillPossible(false) == true) {
					temp.setNext(false);
					queue.enqueue(temp);
				//}
				
			}

		}

		return solutions;

	}

	public static void main(String[] args) {

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);

		ArrayList<Solution> s = solve(width,height);

		

		for(int i = 0;i<s.size(); i++){
			if(i == 0){
				System.out.println("****");

			}
			
			//System.out.println("Solution " + (i+1) + ":");
			System.out.println(s.get(i));

			if(i < s.size()-1){
				System.out.println("****");
			}
		}

		System.out.println("In a board of " + width +"x" + height + ": " + s.size() +" solutions.");
		
	}
	

	

	


}
