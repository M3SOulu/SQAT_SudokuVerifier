
public class SudokuVerifier {
	
	public int verifyCorrectCharacters(String input) {
		int lengthOf = candidateSolution.length();
		String legals = "123456789";
		for (int i = 0; i < lengthOf; i++) {
			if(legals.indexOf(candidateSolution.charAt(i)) < 0) {
				return -1;
			}
		}
		return 0;
	}
	
	public int verify(String candidateSolution) {
		
		if(candidateSolution.length() != 81) {
			return -2;
		}
		
		if(verifyCorrectCharacters(candidateSolution) != 0) {
			return -1;
		}
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
}
