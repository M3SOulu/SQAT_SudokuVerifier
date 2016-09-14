
public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {
		if (isStringLenghtCorrect(candidateSolution) == 0) 
			return 0;
		else if (splitStringToRows(candidateSolution) == 0)
			return 0;
		else if (checkNumbersInLines(candidateSolution) == 0)
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
	
	public static int splitStringToRows(String candidateSolution){
		 String[] rows = splitStringToRows(candidateSolution);
		if (rows.length == 9)
			return 0;
		return -1;
	}
	
	public static int checkNumbersInLines(String candidateSolution){
		String[] rows = candidateSolution.split("(?<=\\G.{9})");
		//for (int i=0; i<9; i++){
			String tempRow = candidateSolution[1];
			System.out.print(tempRow);
		//}
		
		return -1;
	}
	
}
