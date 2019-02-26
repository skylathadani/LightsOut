public class test{
	public static void main(String[] args) {
		Boolean [][] x = new Boolean [3][2];

		x[0][0] = true;
		x[1][0] = false;
		x[2][0] = true;
		x[0][1] = true;
		x[1][1] = false;
		x[2][1] = true;

		Boolean [][] y = new Boolean [x.length][x[0].length];

		for(int i = 0 ; i < y.length; i++){
			for(int j = 0; j < y[0].length; j++){
				y[i][j] = x[i][j];
			}
		}

		for(int i = 0 ; i < y.length; i++){
			for(int j = 0; j < y[0].length; j++){
				System.out.print(y[i][j]+ ",");
			}
		}

		System.out.println("^y");

		for(int i = 0 ; i < y.length; i++){
			for(int j = 0; j < y[0].length; j++){
				System.out.print(x[i][j]+ ",");
			}
		}

		System.out.println("^x");


		x[0][0] = false;
		x[1][0] = true;

		for(int i = 0 ; i < y.length; i++){
			for(int j = 0; j < y[0].length; j++){
				System.out.print(x[i][j]+ ",");
			}
		}

		System.out.println("^x");


		for(int i = 0 ; i < y.length; i++){
			for(int j = 0; j < y[0].length; j++){
				System.out.print(y[i][j]+ ",");
			}
		}

		System.out.println("^y");




	}
}