
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
	
	public int verifyCorrectRows(String input) {
		String validate;
		boolean [] validated = new boolean[9];
		for (int i = 0; i < 9; i ++) {
			validate = input.substring(i * 9, i * 9 + 9);
			for(int j = 0; j < 9; j++) {
				int index = Character.getNumericValue(validate.charAt(j));
				
				if(validated[index - 1]) {
					return -1;
				}
				else {
					validated[index - 1] = true;
				}
			}
			validated = new boolean[9];
		}
		return 0;
	}
	
	public int verifyCorrectSubgrids(String input) {
		String validate;
		boolean [] validated = new boolean[9];
		for (int y = 0; y < 3; y ++) {
			for (int x = 0; x < 3; x ++) {
				
					validate = "";
					for(int s = 0; s < 3; s++) {
						validate += input.substring(x * 3 + y * 3 * 9 + s * 9, x * 3 + 3 + y * 3 * 9 + s * 9);
						
					}
					
					for(int k = 0; k < 9; k++) {
					
						int index = Character.getNumericValue(validate.charAt(k));
						
						if(validated[index - 1]) {
							return -1;
						}
						else {
							validated[index - 1] = true;
						}
					}
					validated = new boolean[9];
				
			}
		}
		return 0;
	}
	
	public int verifyCorrectColumns(String input) {
		String validate;
		boolean [] validated = new boolean[9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				validate = "";
				validate += input.charAt(x + y * 9);
				for(int k = 0; k < 9; k++) {
					
					int index = Character.getNumericValue(validate.charAt(k));
					
					if(validated[index - 1]) {
						return -4;
					}
					else {
						validated[index - 1] = true;
					}
				}
				validated = new boolean[9];
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
		
		if(verifyCorrectSubgrids(candidateSolution) != 0) {
			return -2;
		}
		
		if(verifyCorrectRows(candidateSolution) != 0) {
			return -3;
		}
		
		if(verifyCorrectColumns(candidateSolution) != 0) {
			return -4;
		}
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
}
