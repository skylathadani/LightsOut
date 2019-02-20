public class LightsOut{
	public ArrayList<Solution> solve(int width, int height){
		final long startTime = System.nanoTime();
		partialSolutions = new ArrayListSolutionQueue();
		Solution x = new Solution(width,height);
		partialSolutions.enqueue(x);
		ArrayList <Solutions> solutions = new ArrayList <Solutions> ();

		while(partialSolutions.isEmpty()==false){
			Solution current = partialSolutions.dequeue();

			if(current.isReady() && current.isSucessful()){
				solutions.add(current);
				final long duration = System.nanoTime() - startTime;

				System.out.println("A solution has been found in " + duration);
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

		solver = new solve(3,3);



		System.out.println("The number of solutions found is " + solver.size());

		System.out.println("The Solutions are:");

		for(int i = 0, i < solver.size(); i++){
			System.out.println(solver.get(i));
		}
	}
}
