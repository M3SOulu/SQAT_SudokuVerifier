import java.util.Arrays;

public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		
		if (verifyPositiveNumbers(candidateSolution) != 0) {
			return -1;
		}
		
		if (verifyRows(candidateSolution) != 0) {
			return -3;
		}
		
		// returns 0 if the candidate solution is correct
		return 0;
		//check
	}
	
	public static int verifyPositiveNumbers (String candidateSolution) {
		boolean negativeOrLetter = false;
		int i = 0;
		
		while ((i < 81) && (!negativeOrLetter)) {
			if (!Character.isDigit(candidateSolution.charAt(i))) {
				negativeOrLetter = true;
				return -1;
			}
			i++;
		}
		return 0;
	}
	
	public static int verifyRows (String candidateSolution) {
		boolean rowOk = true;
		int i = 0;
		boolean [] row = new boolean [9];
		int aux;
		int count = 1;
		i = 0;
		while ((i < 81) && (rowOk)) {
			Arrays.fill(row, false);
			while ((i < 9 * count) && (rowOk)) {
				aux = Character.getNumericValue(candidateSolution.charAt(i));
				row[aux - 1] = true;
				i++;
			}
			for (int j = 0; j < 9; j++) {
				if (!row[j]) {
					rowOk = false;
					return -3;
				}
			}
			count++;
			
		}
		return 0;
	}
	
	public static int verifySubGrids (String candidateSolution) {
		boolean subGridOk = true;
		
		return 0;

	}
	
	public static int verifyCols (String candidateSolution) {
		boolean colOk = true;
		int i = 0;
		boolean [] col = new boolean [9];
		int aux;
		int count = 1;
		i = 0;
		while ((i < 81) && (rowOk)) {
			Arrays.fill(rowsOrCols, false);
			while ((i < 9 * count) && (rowOk)) {
				aux = Character.getNumericValue(candidateSolution.charAt(i));
				rowsOrCols[aux - 1] = true;
				i++;
			}
			for (int j = 0; j < 9; j++) {
				if (!rowsOrCols[j]) {
					rowOk = false;
					return -3;
				}
			}
			count++;
			
		}
		return 0;

	}
}
