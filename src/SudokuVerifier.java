
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		//Check length just to be sure
		if (candidateSolution == null || candidateSolution.length() != 81)
			return -1;
		
		//Rule 1: only numbers 1-9
		if (!candidateSolution.matches("[1-9]+"))
			return -1;
		
		
		//Rule 2: all digits only once in a sub-grid
		String[][] subGrids = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				subGrids[i][j] = "";
			}
		}
		
		int x, y;
		for (int i = 0; i < candidateSolution.length(); i++) {
			x = Math.floorDiv((i % 9), 3);
			y = Math.floorDiv(Math.floorDiv(i, 9), 3);
			
			subGrids[x][y] = subGrids[x][y].concat(String.valueOf(candidateSolution.charAt(i)));
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 1; k <= 9; k++)
					subGrids[i][j] = subGrids[i][j].replaceFirst(String.valueOf(k), "");
				
				if (subGrids[i][j].length() != 0)
					return -2;
			}
		}
		
		
		//Rule 3: digit can appear only once in a row
		String[] splitRows = new String[9];
		for (int i = 0; i < 9; i++) {
			splitRows[i] = candidateSolution.substring(i * 9, (i + 1) * 9);
			
			for (int j = 1; j <= 9; j++)
				splitRows[i] = splitRows[i].replaceFirst(String.valueOf(j), "");

			if (splitRows[i].length() != 0)
				return -3;
		}
		
		
		//Rule 4: digit can appear only once in a column
		String[] splitColumns = new String[9];
		for (int i = 0; i < splitColumns.length; i++)
			splitColumns[i] = "";
		
		for (int i = 0; i < 81; i++)
			splitColumns[i % 9] = splitColumns[i % 9].concat(String.valueOf(candidateSolution.charAt(i)));
		
		for (int i = 0; i < splitColumns.length; i++) {
			for (int j = 1; j <= 9; j++)
				splitColumns[i] = splitColumns[i].replaceFirst(String.valueOf(j), "");
			
			if (splitColumns[i].length() != 0)
				return -4;
		}
		
		
		return 0;
	}
}
