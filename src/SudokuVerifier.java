import java.util.*;

public class SudokuVerifier {
	private int[][] sudoku;
	
	public int verify(String candidateSolution) {
		String verifiable = candidateSolution;
		sudoku = new int [9][9];
		
		//Check R1
		if(checkIfStringValid(verifiable) == -1) {
			return -1;
		}
		//Read into multidimensional array
		readIntoArray(verifiable);
		
		//Iterate through
		for(int i = 0; i < sudoku.length; i++) {
			for(int j = 0; j < sudoku.length; j++) {
				int sudokuCell = sudoku[i][j]; 
				//Check rows (R3)
				for(int x = 0; x < sudoku.length; x++) {
					if((j != x) && (sudokuCell == sudoku[i][j])) {
						return -3;
					}
				}
			}
		}

		return 0;
		
		}
		
	
	public int[][] getSudoku() {
		return this.sudoku;
	}
	
	private int checkIfStringValid(String sudoku) {
		if(!(sudoku.matches("[0-9]+") && sudoku.length() == 81)) {
			return -1;
		}
		return 1;
	}
		
	private void readIntoArray(String verifiable) {
		int helper = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Character.getNumericValue(verifiable.charAt(helper));
				helper++;
			}
		}
	}
}
