
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (isStringLenghtCorrect(candidateSolution) == 0) 
			return 0;
		else if (amountOfRows(candidateSolution) == 0)
			return 0;
		else if (rowContainsOnlyPositiveDigits(candidateSolution) == 0)
			return 0;
		return -1;
		
		//check
	}
	
	public static int isStringLenghtCorrect(String candidateSolution){
		if (candidateSolution.length() == 81)
			return 0;
		return -1;
	}
	
	public static String[] splitStringToRows(String candidatesolution){
		String[] rows = candidatesolution.split("(?<=\\G.{9})");
		return rows;
	}
	
	public static int amountOfRows(String candidateSolution){
		String[] rows = splitStringToRows(candidateSolution);
		if (rows.length == 9)
			return 0;
		return -1;
	}
	
	public static int rowContainsOnlyPositiveDigits(String candidateSolution){
		 String[] rows = splitStringToRows(candidateSolution);
		 for (int i=0; i<9; i++){
			String tempRow = rows[1];
			if (tempRow.contains("-") == true)
				return -1;
		 }
		return 0;
	}
	
}
