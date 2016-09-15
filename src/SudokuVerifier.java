
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
		else		// returns 0 if the candidate solution is correct.
			return 0;
	}
	public boolean isDigitsOnly(String str) {
		if(str.length() != 81) // Check length
			return false;
		
		for (int i=0; i<81; i++){ // Check every digit as char.
			char digit = str.charAt(i);
			if(!(0<=digit && digit<=9)) // If not between 0 and 9 return false.
				return false;
		}
		System.out.println("sad");
		return true;
	}

	public boolean noRepeatInSubGrid(String str) {
		return false;
	}
	
	public boolean noRepeatInRows(String str) {
		return false;
	}

	public boolean noRepeatInColumns(String str) {
		return false;
	}

	


}
