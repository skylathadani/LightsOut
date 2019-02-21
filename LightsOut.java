import java.util.*;
public class LightsOut{

	public static ArrayList <Solution> solve(int width,int height){

		ArrayListSolutionQueue queue = new ArrayListSolutionQueue();

		ArrayList<Solution> solutions = new ArrayList<Solution>();

		Solution x = new Solution(width,height);

		queue.enqueue(x);


		while(!(queue.isEmpty())){

			Solution current = queue.dequeue();

			if(current.isReady() && current.isSuccessful()){
				solutions.add(current);
			}else if(current.isReady() == false){
				//Solution temp = new Solution(current);

				current.setNext(true);
				//temp.setNext(false);

				queue.enqueue(current);
				//queue.enqueue(temp);
			}

		}

		return solutions;

	}

	public static void main(String[] args) {

		ArrayList<Solution> s = solve(2,2);

		for(int i = 0;i<s.size(); i++){
			System.out.println(s.get(i));
		}
		
	}
	

	

	


}
