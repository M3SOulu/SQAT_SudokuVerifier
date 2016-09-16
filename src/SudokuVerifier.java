import java.util.ArrayList;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) throws Exception {
		// returns 0 if the candidate solution is correct
		
		Board board = new Board(candidateSolution);
		
		if (!board.hasValidCharacters()) return -1;
		if (!board.hasUniqueSubGrids()) return -2;
		if (!board.hasUniqueRowElements()) return -3;
		if (!board.hasUniqueColumnElements()) return -4;
		
		
		if (candidateSolution.length() != 81)
			throw new Exception("Invalid board dimensions");
		
		for (char c : candidateSolution.toCharArray())
			if (c < '1' || c > '9') return -1;

		for (int y = 0; y < 9; y++) {
			String reserved = "";
			for (int x = 0; x < 9; x++) {
				char c = candidateSolution.charAt(y * 9 + x);
				if (reserved.indexOf(c) != -1)
					return -3;
				reserved += c;
			}
		}

		for (int x = 0; x < 9; x++) {
			String reserved = "";
			for (int y = 0; y < 9; y++) {
				char c = candidateSolution.charAt(y * 9 + x);
				if (reserved.indexOf(c) != -1)
					return -4;
				reserved += c;
			}
		}
		
		for (int gY = 0; gY < 3; gY++) {
			for (int gX = 0; gX < 3; gX++) {
				String reserved = "";
				for (int sY = 0; sY < 3; sY++) {
					for (int sX = 0; sX < 3; sX++) {
						char c = candidateSolution.charAt(
								(sY + gY * 3) * 9 + (sX + gX * 3));
						
						if (reserved.indexOf(c) != -1)
							return -2;
						
						reserved += c;
					}
				}
			}
		}
		
		return 0;
	}
	
	private boolean isValidSize(String candidateSolution) {
		
	}
	
	private boolean hasValidCharacters(String candidateSolution) {
		
	}

	private boolean hasColumnDuplicates(String candidateSolution) {
		
	}
	
	private boolean hasRowDuplicates(String candidateSolution) {
		
	}
}
