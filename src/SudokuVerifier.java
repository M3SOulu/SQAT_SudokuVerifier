import java.util.Arrays;

public class SudokuVerifier {
	private final int GLOBAL_GRID_SIZE = 81;
	private final int SUB_GRID_SIZE = 9;

	public final int NO_ERROR = 0;
	public final int SUBGRID_ERROR = -2;
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int error = 0;
		
		
		//check whole string length?
		
		error = checkSubGrid(candidateSolution);
		
		return error;
	}
	
	public int verifySubGrid(String candidateSolution) {
		return checkSubGrid(candidateSolution);
	}
	
	private int checkSubGrid(String candidateSolution){
		int error = 0;
		int[] testSet = new int[SUB_GRID_SIZE];
		
		for (int i = 0; i < GLOBAL_GRID_SIZE; i = i + 9) {
			// next 9 numbers to test set
			for (int k = 0; k < SUB_GRID_SIZE; k++) {
				testSet[k] = Integer.parseInt(Character.toString(candidateSolution.charAt(i + k)));
			}
			
			Arrays.sort(testSet);
			
			for (int k = 1; k <= SUB_GRID_SIZE; k++) {
				if (k != testSet[k]) {
					error = SUBGRID_ERROR;
					break;
				}
			}
			
			if (NO_ERROR != error)
				break;
		}

		return error;
	}
}
