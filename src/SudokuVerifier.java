import java.util.regex.Pattern;

public class SudokuVerifier {
	/**
	 * Verifies a Sudoku solution.
	 * 
	 * @param candidateSolution All 81 digits
	 * @return 0 if solution is correct, 1 if incorrect
	 */
	public int verify(String candidateSolution) throws IllegalArgumentException {
		// Initial rule: There has to be 81 digits
		if (candidateSolution.length() != 81) {
			throw new IllegalArgumentException("A Sudoku solution's length has to be 81 digits.");
		}
		
		// R1: A cell can only store positive digits, i.e. 1...9
		Pattern illegalCharsPattern = Pattern.compile("[^1-9]");
		boolean illegalCharsFound = illegalCharsPattern.matcher(candidateSolution).find();
		if (illegalCharsFound) {
			return -1;
		}
		
		// R2: All digits appear only once in a sub-grid, i.e. they cannot repeat
		
		
		// Return 0 if the candidate solution is correct
		return 0;
	}
}
