
public class SudokuVerifier {
	
	public int verify(String candidateSolution) throws Exception {
		// returns 0 if the candidate solution is correct
		
		if (candidateSolution.length() != 81)
			throw new Exception("Invalid board dimensions");
		
		for (char c : candidateSolution.toCharArray())
			if (c < '1' || c > '9') return 1;
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				
			}
			
		}
		
		return 0;
		
		//check
	}
}
