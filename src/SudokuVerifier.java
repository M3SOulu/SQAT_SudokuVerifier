import java.util.Arrays;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int array[][] = new int[9][9];
		int row[] = new int[9];
		int box[] = new int[9];
		int column[] = new int[9];
		int num;
		int substrnum = 0;

		
		//Parse the string into array[][]
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				// assign 9 values to the first row
				num = Integer.parseInt(candidateSolution.substring(substrnum, substrnum+1));
				array[i][j] = num;	
				//System.out.println(array[i][j]);
				substrnum++;
				}
			
			}
		//place the set of numbers to it's corresponding array
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++)
			{
				row[j] = array[i][j];
				box[j] = array[(i/3) * 3 + j / 3][i * 3 % 9 + j % 3];
				column[j] = array[j][i];
			}
			//Check cells for positive digits
			if (!checkPositive(array)){
				return -1;
			}
			//Check sub-grids
			if (!validateNum(box)){
				return -2;
			}
			//Check rows
			if (!validateNum(row)){
				return -3;
			}
			//Check columns
			if (!validateNum(column)){
				return -4;
			}
		}

		
		return 0;
	}
	private boolean checkPositive(int[][] positive){
	
		for(int i = 0; i<=8; i++){
			for(int j = 0; j<=8; j++){
				if (positive[i][j]<0){
					return false;
				}
			}
		}
		return true;
	}
	private boolean validateNum(int[] validate){
		
		int i = 0;
		Arrays.sort(validate);
		for (int number : validate){
			if (number !=++i)
				return false;
		}

		
		return true;

	}

	private static void validate() {
		
		//SudokuVerifier verifier = new SudokuVerifier();
		//verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
	}
	
	public static void main(String[] args) {
		//validate();
	}
	
	
}
