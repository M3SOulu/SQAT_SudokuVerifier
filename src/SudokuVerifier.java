
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (candidateSolution.length() < 81 || candidateSolution.length() > 81) {
			return 1;
		}
		
		return 0;
		
		//check
	}
}
