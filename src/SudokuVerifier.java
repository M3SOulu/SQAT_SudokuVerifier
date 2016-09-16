public class SudokuVerifier {
	
	public int verify(String candidateSolution) throws Exception {
		// returns 0 if the candidate solution is correct
		
		if (!isValidLength(candidateSolution))
			throw new Exception("Invalid board dimensions");
		
		if (!isAllCharactersValid(candidateSolution))       return -1;
		if (!isAllRowElementsUnique(candidateSolution))     return -3;
		if (!isAllColumnElementsUnique(candidateSolution))  return -4;
		if (!isAllSubGridElementsUnique(candidateSolution)) return -2;
		
		return 0;
	}
	
	private boolean isValidLength(String candidateSolution) {
		return (candidateSolution.length() == 81);
	}
	
	private boolean isAllCharactersValid(String candidateSolution) {
		for (char c : candidateSolution.toCharArray())
			if (c < '1' || c > '9') return false;
		return true;
	}

	private boolean isAllSubGridElementsUnique(String candidateSolution) {
		for (int gY = 0; gY < 3; gY++) {     // Global grid y
			for (int gX = 0; gX < 3; gX++) { // Global grid x
				String reserved = "";
				for (int sY = 0; sY < 3; sY++) {     // Sub grid y
					for (int sX = 0; sX < 3; sX++) { // Sub grid x
						char c = candidateSolution.charAt(
								(sY + gY * 3) * 9 + (sX + gX * 3));
						
						if (reserved.indexOf(c) != -1)
							return false;
						
						reserved += c;
					}
				}
			}
		}
		
		return true;
	}

	private boolean isAllRowElementsUnique(String candidateSolution) {
		for (int y = 0; y < 9; y++) { // Row by row
			String reserved = "";
			for (int x = 0; x < 9; x++) {
				char c = candidateSolution.charAt(y * 9 + x);
				if (reserved.indexOf(c) != -1)
					return false;
				reserved += c;
			}
		}
		return true;
	}
	
	private boolean isAllColumnElementsUnique(String candidateSolution) {
		for (int x = 0; x < 9; x++) { // Column by column
			String reserved = "";
			for (int y = 0; y < 9; y++) {
				char c = candidateSolution.charAt(y * 9 + x);
				if (reserved.indexOf(c) != -1)
					return false;
				reserved += c;
			}
		}
		return true;
	}
}
