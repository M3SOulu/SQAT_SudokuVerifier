
public class SudokuVerifier {

	public int verify(String candidateSolution) {
		
		String sudokuString = candidateSolution;
		
		
		
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
		

	}
	
	public static int checkRowSudokuString(String candidateSolution){
		
		
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
