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
		row = 1;
		col = 1;
		count = 0;
	}

	public Solution(Solution other) {
		Solution n = new Solution;
		n = other;
	}

	public void setNext(boolean nextValue){

		//ok im pretty sure thats how the method should be written but i could be wrong
		//https://piazza.com/class/jpvulq1lvgm6fs?cid=517  -> thing on piazza that had more instructions

		count++;

		if(count < x.length){
			x[count][col] = nextValue;
		}else{
			System.out.println("Too many calls to setNext have been used. Board is not big enough");
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
}