import java.util.ArrayList;

public class Board {
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
}
