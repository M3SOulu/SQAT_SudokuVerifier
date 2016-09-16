import java.util.ArrayList;

public class Board {
	// All cells are tightly packed for possibly better
	// efficiency
	private ArrayList<Integer> mCells;
	
	Board(String data) throws Exception {
		if (candidateSolution.length() != 81)
			throw new Exception("Invalid board dimensions");
		
	}
	
	boolean hasValidCharacters() {
		for (char c : candidateSolution.toCharArray())
			if (c < '1' || c > '9') return false;
		
		return true;
	}

	boolean isAllRowElementsUnique() {
		for (int y = 0; y < 9; y++) {
			String reserved = "";
			for (int x = 0; x < 9; x++) {
				char c = candidateSolution.charAt(y * 9 + x);
				if (reserved.indexOf(c) != -1)
					return -3;
				reserved += c;
			}
		}
	}
	
	boolean isAllColumnElementsUnique() {
		for (int x = 0; x < 9; x++) {
			String reserved = "";
			for (int y = 0; y < 9; y++) {
				char c = candidateSolution.charAt(y * 9 + x);
				if (reserved.indexOf(c) != -1)
					return -4;
				reserved += c;
			}
		}
	}
	
	boolean isSubGridsUnique() {
		
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
}
