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
	private int count;
	private int cCompare;
	private int row;
	private int col;

	public Solution(int width, int height) {
		x = new Boolean [width][height];
		this.count = width * height;
		//needed these variables for setNext, couldnt leave them as global variables because every instance of "solution" would have changed their value
		this.row = -1;
		this.col = 0;
		this.cCompare = 0;
		
	}

	public Solution(Solution other) {
		x = new Boolean [other.x.length][other.x[0].length];
		this.row = -1;
		this.col = 0;
		this.cCompare = 0;
		for(int i = 0; i < other.x.length; i++){
			for(int j = 0; j < other.x[0].length; j++){
				this.x[i][j] = other.x[i][j];
			}
		}

	}

	public void setNext(boolean nextValue) {
		//Checks if last element in last array is null
		/*if(this.x.cCompare == this.x.count) {
			System.out.println("Too many calls to setNext");
		}
		else {	
		
			//Loops thorugh every element in every array till it finds a null value and sets it too 'nextValue'.
			for(int i = 0; i < this.x[0].length; i++) {
				for(int j = 0; j < this.x.length; j++ ) {
					if(this.x[j][i] == null) {
						this.x[j][i] = nextValue;
						i = this.x.length;
						break;
					}
				}
			}
		}*/

		//ok im pretty sure thats how the method should be written but i could be wrong
		//https://piazza.com/class/jpvulq1lvgm6fs?cid=517  -> thing on piazza that had more instructions
		//also the first call starts at position (0,0) cuz that makes sense since the array starts at (0,0) idk what the instructions even want
	   this.row++;
       
       if(this.row >= this.x.length){
         	this.row = 0;
         	this.col++;
       } 
       
       if(this.row < this.x.length && this.col < this.x[0].length){
           x[this.row][this.col] = nextValue;
           this.cCompare++;
       }
       else{
         System.out.println("Too many calls to setNext");
         this.cCompare = this.count;
       }
	

	}	

	public boolean isReady() {
		/*if(this.cCompare >= this.count) {
			return true;
		}*/

		for(int i = 0; i < this.x.length; i++){
			for(int j = 0; j < this.x[0].length;j++){
				if(this.x[i][j] == null){
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSuccessful() {
		if(this.isReady() == false){
			return false;
		}

		//if you read the assignment, theres a proof that if each block is changed and odd number of times
		// the solution is always successful, thats what i did below

		if(this.isReady()){
			int[][] test = new int [this.x.length][this.x[0].length];

			for(int i = 0; i < this.x.length; i++){
				for(int j = 0; j < this.x[0].length; j++){
					
					if(this.x[i][j] == true){
						test[i][j] ++;
						if(i-1 > -1){
							test[i-1][j]++;
						}
						if(j+1 < test[0].length){
							test[i][j+1]++;
						}
						if(i+1 < test.length){
							test[i+1][j]++;
						}
						if(j-1 > -1){
							test[i][j-1]++;
						}
					}
				}
			}

			//this is me testing if the numbers incremented correctly

			for(int i = 0; i < test.length; i++){
				for(int j = 0; j < test[0].length; j++){
					System.out.print(test[i][j] + ",");
				}
			}
			System.out.println("****");

			//testing if all numbers are odd

			for(int i = 0; i < test.length;i++){
				for(int j = 0; j < test[0].length; j++){
					if(test[i][j]%2 == 0){
						return false;
					}
				}
			}

		}





















		/*if(this.isReady() == false){
			return false;
		}
		if(isReady()) {
			Solution g = new Solution(this.x.length, this.x[0].length);
			for(int k=0; k < x.length; k++) {
				for(int j=0; j< x[0].length; j++) {
					g.x[k][j] = false;
				}
			}
			for(int i=0; i < x.length; i++) {
				for(int j=0; j < x[0].length; j++) {
					if(this.x[i][j] == true) {
						if(i == 0 && j == 0) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i+1][j] = !(g.x[i+1][j]);
							g.x[i][j+1] = !(g.x[i][j+1]);
						}
						else if(i == 0 && j == x[0].length-1) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i+1][j] = !(g.x[i+1][j]);
							g.x[i][j-1] = !(g.x[i][j-1]);
						}
						else if(i == this.x.length-1 && j == 0) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i-1][j] = !(g.x[i-1][j]);
							g.x[i][j+1] = !(g.x[i][j+1]);
						}
						else if(i == this.x.length-1 && j == this.x[0].length-1) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i-1][j] = !(g.x[i-1][j]);
							g.x[i][j-1] = !(g.x[i][j-1]);
						}
						else if(j == 0) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i+1][j] = !(g.x[i+1][j]);
							g.x[i][j+1] = !(g.x[i][j+1]);
							g.x[i-1][j] = !(g.x[i-1][j]);
						}
						else if(j == this.x[0].length -1) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i+1][j] = !(g.x[i+1][j]);
							g.x[i][j-1] = !(g.x[i][j-1]);
							g.x[i-1][j] = !(g.x[i-1][j]);
						}
						else if(i == 0) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i+1][j] = !(g.x[i+1][j]);
							g.x[i][j+1] = !(g.x[i][j+1]);
							g.x[i][j-1] = !(g.x[i][j-1]);
						}
						else if(i == this.x.length -1) {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i-1][j] = !(g.x[i-1][j]);
							g.x[i][j+1] = !(g.x[i][j+1]);
							g.x[i-1][j] = !(g.x[i-1][j]);
						}
						else {
							g.x[i][j] = !(g.x[i][j]);
							g.x[i+1][j] = !(g.x[i+1][j]);
							g.x[i][j+1] = !(g.x[i][j+1]);
							g.x[i-1][j] = !(g.x[i-1][j]);
							g.x[i][j-1] = !(g.x[i][j-1]);
						}
					}
				}
			}
			for(int i = 0; i < this.x.length; i++) {
				for(int j=0; j < this.x[0].length; j++) {
					if(g.x[i][j] == false) {
						return false;
					}
				}
			}
			return true;
		}
		return false;*/

		return true;
	}

	@Override
	public boolean equals(Object other) {
        if(this == other){
            return true;
        }
        if(other == null) {
            return false;
        }

        if(!(other instanceof Solution)) {
            return false;
        }
        // int variable cannot be null so not checked for in variable year.
        if(this.isReady() == false) {
            return false;
        }
        Solution otherS = (Solution) other;
        for(int i = 0; i < this.x.length; i++){
			for(int j = 0; j < this.x[i].length; j++){
				if(this.x[i][j] != otherS.x[i][j]){
					return false;
				}
			}
		}
        return true;
    }

	public String toString() {


		
  		String aString = "[";
  		for(int i = 0; i < this.x[0].length; i++) {
  			aString +="[";
			for(int j = 0; j < this.x.length; j++ ) {
        		if(j < this.x.length - 1) {
        			aString += this.x[j][i] + ", ";
        		}
        		else {
        			aString += this.x[j][i];
        		}
    		}
    		if(i < this.x[0].length -1) {
    			aString += "],";
    			aString += "\r\n";
    		}
    		else {
    			aString += "]";
    		}
  		}
  		aString += "]";
  		return aString;
	}

	public static void main(String[] args) {
		Solution solution;
		solution = new Solution(2,2);
		solution.setNext(true);
		solution.setNext(true);
		solution.setNext(false);
		System.out.println("Midway - Solution is ready: " + solution.isReady());
		solution.setNext(true);
		solution.setNext(true);
		solution.setNext(false);
		System.out.println("The solution is:");
		System.out.println(solution);
		System.out.println("Solution is ready: " + solution.isReady());
		System.out.println("Solution is successful: "+solution.isSuccessful());

	}
}