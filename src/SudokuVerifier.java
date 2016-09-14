import java.util.Arrays;

public class SudokuVerifier {
	private final int GLOBAL_GRID_SIZE = 81;
	private final int SUBGRID_AND_ROW_SIZE = 9;

	public final int NO_ERROR = 0;
	public final int SUBGRID_ERROR = -2;
	public final int GLOBAL_ROW_ERROR = -3;
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int error = 0;
		
		
		//check whole string length?
		
		//error = verifySubGrid(candidateSolution);
		
		error = verifyGlobalRow(candidateSolution);
		
		return error;
	}
	
	public int verifySubGrid(String candidateSolution) {
		return checkSubGrid(candidateSolution);
	}
	
	public int verifyGlobalRow(String candidateSolution) {
		return checkGlobalRow(candidateSolution);
	}
	
	private int checkGlobalRow(String candidateSolution) {
		//boolean debug = false;
		int[] testSet = null;
		
		for (int i = 0; i < GLOBAL_GRID_SIZE; i = i + 9) {
			// next 9 numbers to test set
			testSet = getGlobalRow(candidateSolution, i);
			
			if (!membersUnique(testSet))
				return GLOBAL_ROW_ERROR;
		}

		return NO_ERROR;
	}
	
	private int checkSubGrid(String candidateSolution){
		int[] testSet = null;
		
		for (int i = 0; i < GLOBAL_GRID_SIZE; i = i + 9) {
			// next 9 numbers to test set
			testSet = getSubgrid(candidateSolution, i);

			if (!membersUnique(testSet))
				return SUBGRID_ERROR;
		}

		return NO_ERROR;
	}
	
	private boolean membersUnique(int[] testSet) {
		boolean debug = false;

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
	
	/* subgrid nums
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */
	private int[] getSubgrid(String candidateSolution, int subgridNum) {
		int[] subgridCellValues = new int[SUBGRID_AND_ROW_SIZE]; 
		// 417369825632158947958724316825437169791586432346912758289643571573291684164875293
		
		final int SUBGRID_ROW_AMOUNT = 3;
		final int ROW_INDEX_AMOUNT = 9;
		for (int i = 0; i < SUBGRID_ROW_AMOUNT; i++) {
			int k = 0;
			int cellIndex = (i * ROW_INDEX_AMOUNT) + (3 * subgridNum);
			
			while (k < 3) {
				
				cellIndex++;
				k++;
			}
			//use subgrid num in right way instead of int
			//testSet[k] = Integer.parseInt(Character.toString(candidateSolution.charAt(i + k)));
		}
		
		return subgridCellValues;
	}
	
	private int[] getGlobalRow(String candidateSolution, int rowNum) {
		int[] globalRowNums = new int[SUBGRID_AND_ROW_SIZE];

		/* first row is row 0 */
		for (int i = 0; i < SUBGRID_AND_ROW_SIZE; i++) {
			globalRowNums[i] = Integer.parseInt(Character.toString(candidateSolution.charAt(rowNum + i)));
		}
		
		return globalRowNums;
	}
	
	private void subgridDebug(int[] testSet) {
		for (int k = 0; k < SUBGRID_AND_ROW_SIZE; k++) {
			System.out.print(testSet[k]);
		}
		
		System.out.print("\n");
	}
}
