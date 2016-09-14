
public class SudokuVerifier {
	
	private static char[] rowsOrCols;

	public static int verify(String candidateSolution) {
		boolean negativeOrLetter = false;
		boolean rowOk = false;
		int i = 0;
		char [] solution;
		rowsOrCols = null;
		while ((i < 81) && (!negativeOrLetter)) {
			if (!Character.isDigit(candidateSolution.charAt(i))) {
				negativeOrLetter = true;
				return -1;
			}
			i++;
		}
		i = 0;
		solution = candidateSolution.toCharArray();
		while ((i < 9) && (rowOk)) {
			rowsOrCols[0] = solution[0];
		}
		// returns 0 if the candidate solution is correct
		return 0;
		//check
	}
}
