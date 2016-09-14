
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		String verifiable = candidateSolution;
		
		//Check R1
		if(!(verifiable.matches("[0-9]+") && verifiable.length() == 81)) {
			return -1;
		}
		
		//Check R3
		
		for(int j = 0; j < 81; j=+9) {
			String subset = verifiable.substring(j, j+9);
			System.out.println(subset);
		}

		
		return 0;
		
	}
}
