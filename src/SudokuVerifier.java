
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (candidateSolution.length() < 81 || candidateSolution.length() > 81) {
			return 1;
		}
		if (splitStringToRows(candidateSolution) == 1)
			return 1;
		
		return 0;
		
		//check
	}
	
	public static int splitStringToRows(String candidateSolution){
		String row = candidateSolution.substring(0,5);
		if (isRowLengthRight(row) == 1)
			return 1;
		return 0;
	}
	
	public static int isRowLengthRight(String row){
		System.out.print(row);
		if (row.length() == 9) 
			return 1;
		return 0;
	}
}
