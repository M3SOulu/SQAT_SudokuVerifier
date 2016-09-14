
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (candidateSolution.length() < 81 || candidateSolution.length() > 81) {
			return 1;
		}
		
		return 0;
		
		//check
	}
	
	public static String splitStringToRows(String candidateSolution){
		String row1 = candidateSolution.substring(0,9);
		System.out.print(row1);
		return candidateSolution;
		
	}
}
