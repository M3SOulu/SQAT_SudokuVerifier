
public class SudokuVerifier {
	
	public int verifyCorrectCharacters(String input) {
		int lengthOf = input.length();
		String legals = "123456789";
		for (int i = 0; i < lengthOf; i++) {
			if(legals.indexOf(input.charAt(i)) < 0) {
				return -1;
			}
		}
		return 0;
	}
	
	public int verifyCorrectSubgrids(String input) {
		String validate;
		boolean [] validated = new boolean[9];
		for (int i = 0; i < 9; i ++) {
			validate = input.substring(i * 9, i * 9 + 9);
			for(int j = 0; j < 9; j++) {
				int index = (int)validate.charAt(j);
				System.out.println((int)validate.charAt(j));
				if(validated[index - 1]) {
					return -2;
				}
				else {
					validated[index - 1] = true;
				}
			}
			validated = new boolean[9];
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
		
		if(verifyCorrectSubgrids(candidateSolution) != 0) {
			return -2;
		}
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
}
