
public class SudokuVerifier {
	
	public int verify(String str) {
		if(!isDigitsOnly(str))
			return -1;
		else if(!noRepeatInSubGrid(str))
			return -2;
		else if(!noRepeatInRows(str))
			return -3;
		else if(!noRepeatInColumns(str))
			return -4;
		else		// returns 0 if the candidate solution is correct
			return 0;
	}
	private boolean isDigitsOnly(String str) {
		
		return false;
	}

	private boolean noRepeatInSubGrid(String str) {
		return false;
	}
	
	private boolean noRepeatInRows(String str) {
		return false;
	}

	private boolean noRepeatInColumns(String str) {
		return false;
	}

	


}
