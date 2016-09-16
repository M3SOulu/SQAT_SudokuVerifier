import java.util.ArrayList;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) throws Exception {
		// returns 0 if the candidate solution is correct
		
		Board board = new Board(candidateSolution);
		
		if (!board.isValidFormat()) return -1;
		if (!board.isAllSubGridsUnique()) return -2;
		if (!board.isAllRowElementsUnique()) return -3;
		if (!board.isAllColumnElementsUnique()) return -4;
		

		
		
		return 0;
	}
	
	private boolean isValidSize(String candidateSolution) {
		
	}
	
	private boolean hasValidCharacters(String candidateSolution) {
		
	}

	private boolean coColumnDuplicates(String candidateSolution) {
		
	}
	
	private boolean hasRowDuplicates(String candidateSolution) {
		
	}
}
