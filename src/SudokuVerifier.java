
public class SudokuVerifier {
	
	public int verify(String candidateSolution) throws Exception {
		// returns 0 if the candidate solution is correct
		
		if (candidateSolution.length() != 81)
			throw new Exception("Invalid board dimensions");
		
		for (char c : candidateSolution.toCharArray())
			if (c < '1' || c > '9') return 1;
		
		for (int gY = 0; gY < 3; gY++) {
			for (int gX = 0; gX < 3; gX++) {
				for (int sY = 0; sY < 3; sY++) {
					for (int sX = 0; sX < 3; sX++) {
						coordX = 
					}
				}
			}
		}
		
		return 0;
		
		//check
	}
}
