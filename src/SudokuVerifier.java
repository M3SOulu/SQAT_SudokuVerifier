
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (checkStringLength(candidateSolution) == -1) 
			return -1;
		else if (amountOfRows(candidateSolution) == -1)
			return -1;
		else if (rowContainsOnlyPositiveDigits(candidateSolution) == -1)
			return -1;
		return 0;
		
		//check
	}
	
	public static int checkStringLength(String candidateSolution){
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
			if (tempRow.contains("1") == true)
				return -1;
		 }
		return 0;
	}
	
}
