
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (isStringLenghtCorrect(candidateSolution) == 0) {
			return 0;
		}
		//else if (splitStringToRows(candidateSolution) == 0)
			//return 0;
		
		return -1;
		
		//check
	}
	
	public static int isStringLenghtCorrect(String candidateSolution){
		if (candidateSolution.length() < 81 || candidateSolution.length() > 81)
			return 0;
		return -1;
	}
	
	public static int splitStringToRows(String candidateSolution){
		String row = candidateSolution.substring(0,9);
		if (isRowLengthRight(row) == 0)
			return 0;
		return -1;
	}
	
	public static int isRowLengthRight(String row){
		if (row.length() == 9) 
			return 0;
		return -1;
	}
}
