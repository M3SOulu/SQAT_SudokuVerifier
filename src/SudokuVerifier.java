
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (checkStringLength(candidateSolution) == -1) 
			return -1;
		else if (amountOfRows(candidateSolution) == -1)
			return -1;
		else if (rowContainsOnlyPositiveDigits(candidateSolution) == -1)
			return -1;
		//if (digitAppearsOnceInRow(candidateSolution) == -3)
			//return -3;
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
		String[] rows1 = splitStringToRows(candidateSolution);
		if (rows1.length == 9)
			return 0;
		return -1;
	}
	
	public static int rowContainsOnlyPositiveDigits(String candidateSolution){
		 String[] rows2 = splitStringToRows(candidateSolution);
		 for (int i=0; i<9; i++){
			String tempRow1 = rows2[1];
			if (tempRow1.contains("0") == true)
				return -1;
		 }
		return 0;
	}
	
	/*public static int digitAppearsOnceInRow(String candidateSolution){
		String[] rows3 = splitStringToRows(candidateSolution);
		for (int j=0; j<9; j++){
			String tempRow2 = rows3[j];
			for (int k=0; k<9; k++){
				char tempDigit = tempRow2.charAt(k);
					
				}
			}
		 }
		return 0;
	}*/
	
}
