/**
* @author: Gregory Mitchell
* Student number: 300053307
* Course: ITI 1121-A00
* Assignment: 2

* @author: Skyla Thadani
* Student number: 300055455
* Course: ITI 1121-C00
* Assignment: 2
*/

public class Solution {
	Boolean[][] x;
	int row;
	int col;
	int count;
	public Solution(int width, int height) {
		x = new Boolean[width][height];

//needed these variables for setNext, couldnt leave them as global variables because every instance of "solution" would have changed their value
		row = 0;
		col = -1;
		
	}

	public Solution(Solution other) {
		Solution n = new Solution;
		n = other;
	}

	public void setNext(boolean nextValue){

		//ok im pretty sure thats how the method should be written but i could be wrong
		//https://piazza.com/class/jpvulq1lvgm6fs?cid=517  -> thing on piazza that had more instructions
		//also the first call starts at position (0,0) cuz that makes sense since the array starts at (0,0) idk what the instructions even want
		col++;
       
       if(col >= x[0].length){
         row++;
         col = 0;
         }
        
        if(row < x.length && col < x[0].length){
            x[row][col] = nextValue;
        }else{
          System.out.println("Too many calls to setNext");
        }

	




	}	

	public boolean isReady(){
		for(int i = 0; i < x.length; i++){
			for(int j = 0; j < x[i].length; j++){
				if(x[i][j] != true || x[i][j] != false){

					return false;

				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution solution;
		solution = new Solution(3,2);
		solution.setNext(true);
		solution.setNext(true);
		solution.setNext(false);
		solution.setNext(true);
		solution.setNext(true);
		solution.setNext(false);
	}
}