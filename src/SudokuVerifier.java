
public class SudokuVerifier {

	public int verify(String candidateSolution) {
		
		String sudokuString = candidateSolution;
		
		
		
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
		

	}
	
	public static int checkRow(String candidateSolution){
		
		/* Let's not get fancy yet, just make it work
		int start = 0;
		int stop = 8;
		
		for (int i = 0; i < 9; i++){
		String sudokuRow = candidateSolution.substring(start, stop);
			for (int j = start; j <= stop; j++)7
				break;
			}
		}
		*/
		
		String sudokuRow1 = candidateSolution.substring(0, 8);
		for (int i = 0; i < 9; i++){
			number1 
		}
		String sudokuRow2 = candidateSolution.substring(9, 17);
		String sudokuRow3 = candidateSolution.substring(18, 26);
		String sudokuRow4 = candidateSolution.substring(27, 35);
		String sudokuRow5 = candidateSolution.substring(36, 44);
		String sudokuRow6 = candidateSolution.substring(45, 53);
		String sudokuRow7 = candidateSolution.substring(54, 62);
		String sudokuRow8 = candidateSolution.substring(63, 71);
		String sudokuRow9 = candidateSolution.substring(72, 80);
		
		
		
	}
	
	
	public static int checkSudokuLength(String candidateSolution){
		int sudokuLength = candidateSolution.length();
		if (sudokuLength != 81) {
			return -1;
		}
		else {
			return 0;
		}
		
	}
}
