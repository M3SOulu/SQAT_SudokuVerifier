
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		boolean negativeOrLetter = false;
		boolean rowOk = false;
		int i = 0;
		char [] solution;
		int [] rowsOrCols = null;
		while ((i < 81) && (!negativeOrLetter)) {
			if (!Character.isDigit(candidateSolution.charAt(i))) {
				negativeOrLetter = true;
				return -1;
			}
			i++;
		}
		/////////////////////////////
		solution = candidateSolution.toCharArray();
		i = 0;
		int aux;
		int count = 1;
		while ((i < 81) && (rowOk)) {
			while ((i < 9 * count) && (rowOk)) {
				aux = solution[i];
				rowsOrCols[aux] = aux;
			}
			for (int j = 0; j < 9; j++) {
				if (rowsOrCols[j] != j) {
					rowOk = false;
					return -2;
				}
			}
			count++;
		}
		// returns 0 if the candidate solution is correct
		return 0;
		//check
	}
}
