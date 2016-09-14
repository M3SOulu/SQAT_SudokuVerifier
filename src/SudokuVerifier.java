
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		boolean negative = false;
		char [] solution;
		int i = 0;
		
		while ((i < 81) && (!negative)) {
			solution = candidateSolution.toCharArray();
			if (solution[i] < 0) {
				return -1;
			}
			i++;
		}
		// returns 0 if the candidate solution is correct
		return 0;
		//check
	}
}
