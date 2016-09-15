import java.util.Arrays;

//417369825632158947958724316825437169791586432346912758289643571573291684164875293

		// 417369825
		// 632158947
		// 958724316
		// 825437169791586432346912758289643571573291684164875293

public class SudokuVerifier {
	private final int GLOBAL_GRID_SIZE = 81;
	private final int SUBGRID_AND_ROW_SIZE = 9;

	public final int NO_ERROR = 0;
	public final int DIGIT_ERROR = -1;
	public final int SUBGRID_ERROR = -2;
	public final int GLOBAL_ROW_ERROR = -3;
	public final int GLOBAL_COLUMN_ERROR = -4;
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int error = 0;
		
		//check whole string length?
		
		//error = verifySubGrid(candidateSolution);
		
		//error = verifyGlobalRow(candidateSolution);
		
		return error;
	}
	
	public int verifySubGrid(String candidateSolution) {
		return checkSubGrid(candidateSolution);
	}
	
	public int verifyGlobalRow(String candidateSolution) {
		return checkGlobalRow(candidateSolution);
	}
	
	public int verifyGlobalColumn(String candidateSolution) {
		return checkGlobalColumn(candidateSolution);
	}
	
	public int verifyCellValues(String candidateSolution) {
		return checkCells(candidateSolution);
	}
	
	private int checkGlobalRow(String candidateSolution) {
		int[] testSet = null;
		
		// 9 row amount
		for (int i = 0; i < 9; i++) {
			// next 9 numbers to test set
			testSet = getGlobalRow(candidateSolution, i);
			System.out.println("here, i == " + i);
			if (!membersUnique(testSet))
				return GLOBAL_ROW_ERROR;
		}

		return NO_ERROR;
	}
	
	private int checkSubGrid(String candidateSolution) {
		int[] testSet = null;
		
		// 9 subgrid amount
		for (int i = 0; i < 9; i++) {
			// next 9 numbers to test set
			testSet = getSubgrid(candidateSolution, i);

			if (!membersUnique(testSet))
				return SUBGRID_ERROR;
		}

		return NO_ERROR;
	}
	
	private int checkGlobalColumn(String candidateSolution) {
		int[] testSet = null;
		
		for (int i = 0; i < 9; i++) {
			testSet = getGlobalColumn(candidateSolution, i);
			
			if (!membersUnique(testSet))
				return GLOBAL_COLUMN_ERROR;
		}
		
		return NO_ERROR;
	}
	
	private int checkCells(String candidateSolution) {
		int[] testSet = null;
		
		try {
			testSet = getCellValues(candidateSolution);
		} catch (NumberFormatException e) {
			System.err.println("Char of sudoku string representation was not a number. " + e.getMessage());
			return DIGIT_ERROR;
		}
		
		if (!withinRange(testSet, 1, 9))
			return DIGIT_ERROR;
		
		return NO_ERROR;
	}
	
	private int[] getCellValues(String candidateSolution) throws NumberFormatException {
		int[] cellValues = new int[GLOBAL_GRID_SIZE];
		
		for (int i = 0; i < cellValues.length; i++) {
			cellValues[i] = Integer.parseInt(Character.toString(candidateSolution.charAt(i)));
		}
		
		return cellValues;
	}
	
	private boolean withinRange(int[] testValues, int min, int max) {
		for (int i = 0; i < testValues.length; i++) {
			if (testValues[i] < min || testValues[i] > max)
				return false;
		}
		
		return true;
	}
	
	/* subgrid nums
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */
	private int[] getSubgrid(String candidateSolution, int subgridNum) {
		final int SUBGRID_AMOUNT_ON_ROW = 3;
		int[] subgridCellValues = new int[SUBGRID_AND_ROW_SIZE];
		int resultIndex = 0;
		
		// select subgrid starting global row
		int subgridRow = subgridNum / 3; 
		System.out.println("subgridRow == " + subgridRow);
		int subgridColumn = subgridNum % SUBGRID_AMOUNT_ON_ROW;
		int globalRowIndex = globalRowIndex(subgridRow * 3);
		int subgridStartIndex = subgridStartIndex(globalRowIndex, subgridColumn);
		
		// select 3 subsequent cells from 3 subsequent global rows
		for (int i = 0; i < 3; i++) {
			int column_offset = 0;
			int row_offset = (SUBGRID_AND_ROW_SIZE * i);
			while (column_offset < 3) {
				int index = subgridStartIndex + row_offset + column_offset;
				System.out.println("start " + subgridStartIndex + ", row " + row_offset + ", column " + column_offset);
				System.out.println("index == " + index);
				subgridCellValues[resultIndex] = Integer.parseInt(Character.toString(candidateSolution.charAt(index)));
				column_offset++;
				resultIndex++;
			}
		}
		
		return subgridCellValues;
	}
	
	private int[] getGlobalRow(String candidateSolution, int rowNum) {
		int[] globalRowNums = new int[SUBGRID_AND_ROW_SIZE];

		/* first row is row 0 */
		for (int i = 0; i < SUBGRID_AND_ROW_SIZE; i++) {
			globalRowNums[i] = Integer.parseInt(Character.toString(candidateSolution.charAt(globalRowIndex(rowNum) + i)));
		}
		
		return globalRowNums;
	}
	
	int[] getGlobalColumn(String candidateSolution, int columnNum) {
		int[] globalColumnNums = new int[9];
		int index = -1;
		
		for (int i = 0; i < 9; i++) {
			index = (SUBGRID_AND_ROW_SIZE * i) + columnNum;
			globalColumnNums[i] = Integer.parseInt(Character.toString(candidateSolution.charAt(index)));
		}
		
		return globalColumnNums;
	}
	
	private int globalRowIndex(int globalRowNo) {
		return globalRowNo * SUBGRID_AND_ROW_SIZE;
	}
	
	private int subgridStartIndex(int globalRowIndex, int subgridColumnNo) {
		return globalRowIndex + (3 * subgridColumnNo); // 3 == cells in subgrid
	}
	
	private boolean membersUnique(int[] testSet) {
		boolean debug = true;

		if (debug)
			subgridDebug(testSet); // change name for this function
		
		Arrays.sort(testSet);
		
		if (debug)
			subgridDebug(testSet);
		
		for (int i = 1; i <= testSet.length; i++) {
			if (i != testSet[i - 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	private void subgridDebug(int[] testSet) {
		for (int k = 0; k < SUBGRID_AND_ROW_SIZE; k++) {
			System.out.print(testSet[k]);
		}
		
		System.out.print("\n");
	}
}
