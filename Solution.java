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
	//int row;
	//int col;
	public Solution(int width, int height) {
		x = new Boolean[width][height];

		//needed these variables for setNext, couldnt leave them as global variables because every instance of "solution" would have changed their value
		//row = 0;
		//col = -1;
		
	}

	public Solution(Solution other) {
		Solution n = new Solution(other.x.length, other.x[0].length);

		for(int i = 0; i < other.x.length; i++){
			for(int j = 0; j < x[i].length; j++){
				n.x[i][j] = other.x[i][j];
			}
		}

	}

	public void setNext(boolean nextValue) {
		//Checks if last element in last array is null
		if(this.x[this.x.length-1][this.x[0].length-1] != null) {
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
		}
		//ok im pretty sure thats how the method should be written but i could be wrong
		//https://piazza.com/class/jpvulq1lvgm6fs?cid=517  -> thing on piazza that had more instructions
		//also the first call starts at position (0,0) cuz that makes sense since the array starts at (0,0) idk what the instructions even want
		/*col++;
       
       if(col >= x[0].length){
         row++;
         col = 0;
       }
        
       if(row < x.length && col < x[0].length){
           x[row][col] = nextValue;
       }
       else{
         System.out.println("Too many calls to setNext");
       }
	*/

	}	

	public boolean isReady() {
		for(int i = 0; i < this.x.length; i++){
			for(int j = 0; j < this.x[i].length; j++){
				if(this.x[i][j] == null){
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSuccessful() {
		if(isReady()) {
			return true;
		}
		return false;
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
		solution = new Solution(3,2);
		solution.setNext(true);
		solution.setNext(false);
		solution.setNext(true);
		System.out.println("Midway - Solution is ready: " + solution.isReady());
		solution.setNext(false);
		solution.setNext(true);
		solution.setNext(false);
		System.out.println("The solution is:");
		System.out.println(solution);
		System.out.println("Solution is ready: " + solution.isReady());
	}
}