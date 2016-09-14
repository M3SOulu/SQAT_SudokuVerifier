import java.util.Arrays;

public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		boolean negativeOrLetter = false;
		boolean rowOk = true;
		int i = 0;
		boolean [] rowsOrCols = new boolean [9];
		
		while ((i < 81) && (!negativeOrLetter)) {
			if (!Character.isDigit(candidateSolution.charAt(i))) {
				negativeOrLetter = true;
				return -1;
			}
			i++;
		}
		
		int aux;
		int count = 1;
		while ((i < 81) && (rowOk)) {
			Arrays.fill(rowsOrCols, false);
			while ((i < 9 * count) && (rowOk)) {
				aux = candidateSolution.indexOf(i);
				rowsOrCols[aux] = true;
			}
			for (int j = 0; j < 9; j++) {
				if (!rowsOrCols[j]) {
					rowOk = false;
					return -2;
				}
			}
			count++;
			i++;
		}
		
		// returns 0 if the candidate solution is correct
		return 0;
		//check
	}
}
