
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		String verifiable = candidateSolution;
		
		//Check R1
		if(!(verifiable.matches("[0-9]+") && verifiable.length() == 81)) {
			return -1;
		}
		
		//Check R2
		
		return 0;
		
	}
}
