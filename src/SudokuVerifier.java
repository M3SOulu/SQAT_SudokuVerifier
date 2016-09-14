import java.util.*;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		String verifiable = candidateSolution;
		
		//Check R1
		if(!(verifiable.matches("[0-9]+") && verifiable.length() == 81)) {
			return -1;
		}
		
		//Check R3
		int helper = 0;
		for(int i = 0; i < 81; i=+8) {
			String subset = verifiable.substring(i, i+9);
			for(int j = 0; i < 9; i++) {
				if(i != subset.charAt(helper) && subset.contains(subset.substring(helper, helper))) {
					return -3;
				}
				helper++;
			}
		}

		return 0;
		
	}
}
