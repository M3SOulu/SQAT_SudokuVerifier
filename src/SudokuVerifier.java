
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		boolean negativeOrLetter = false;
		int i = 0;
		
		while ((i < 81) && (!negativeOrLetter)) {
			if (Character.isDigit(candidateSolution.charAt(i))) {
				negativeOrLetter = true;
				return -1;
			}
			i++;
		}
		// returns 0 if the candidate solution is correct
		return 0;
		//check
	}
}
