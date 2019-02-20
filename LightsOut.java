public class LightsOut{
	public ArrayList<Solution> solve(int width, int height){
		partialSolutions = new ArrayListSolutionQueue();
		Solution x = new Solution(width,height);
		partialSolutions.enqueue(x);
		ArrayList <Solutions> solutions = new ArrayList <Solutions> ();

		while(!(partialSolutions.isEmpty()){
			Solution current = partialSolutions.dequeue();

			if(current.isReady() && current.isSucessful()){
				solutions.add(current);
			}else if (current.isReady() == false){

				Solution temp = new Solution(current);

				current.setNext(true);
				temp.setNext(false);

				partialSolutions.enqueue(current);
				partialSolution.enqueue(temp);

			}
		}

		return solutions;
	}

	public static void main(String[] args) {

		System.out.println("The number of solutions found is ")
	}
}
