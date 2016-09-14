import java.util.Arrays;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int error = 0;
		
		
		//check whole string length?
		
		error = checkSubGrid(candidateSolution);
		
		return error;
	}
	
	private int checkSubGrid(String candidateSolution){
		
	}
}
