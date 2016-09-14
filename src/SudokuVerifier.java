import java.util.ArrayList;
import java.util.List;
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
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int beginIndex = i * 27 + j * 3;
				
				StringBuilder subgridBuilder = new StringBuilder();
				subgridBuilder.append(candidateSolution.substring(beginIndex, beginIndex + 3));
				subgridBuilder.append(candidateSolution.substring(beginIndex + 9, beginIndex + 12));
				subgridBuilder.append(candidateSolution.substring(beginIndex + 18, beginIndex + 21));
				String subgrid = subgridBuilder.toString();
				
				for (int number = 1; number < 10; number++) {
					if (!subgrid.contains(Integer.toString(number))) {
						return -2;
					}
				}
			}
		}
		
		// R3: A digit can appear only once in the rows of the global grid
		for (int i = 0; i < 9; i++) {
			int beginIndex = i * 9;
			String row = candidateSolution.substring(beginIndex, beginIndex + 9);
			
			for (int number = 1; number < 10; number++) {
				if (!row.contains(Integer.toString(number))) {
					return -3;
				}
			}
		}
		
		// R4: A digit can appear only once in the columns of the global grid
		for (int i = 0; i < 9; i++) {
			List<Integer> columnNumbers = new ArrayList<Integer>();
			
			for (int j = 0; j < 9; j++) {
				int number = candidateSolution.charAt(i + j * 9);
				
				if (columnNumbers.contains(number)) {
					return -4;
				} else {
					columnNumbers.add(number);
				}
			}
		}
		
		// Return 0 if the candidate solution is correct
		return 0;
	}
}
