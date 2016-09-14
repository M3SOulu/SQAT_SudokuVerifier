
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		String verifiable = candidateSolution;
		
		if(!(verifiable.matches("[0-9]+") && verifiable.length() > 2)) {
			return -1;
		}
		return 0;
		
	}
}
