import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerifyWithCorrect() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		String example = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals("Example sudoku string had to be correct",0,sudoku.verify(example));
	}
	
	@Test
	public void testVerifyWithFalse() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		String example = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		assertEquals("Example sudoku string had to be incorrect",-2,sudoku.verify(example));
	}
	
	@Test
	public void testIsDigitsOnlyWithShorterString(){
		SudokuVerifier sudoku = new SudokuVerifier();
		
		String test = "21321321313";
		
		assertFalse(sudoku.isDigitsOnly(test));
	}
	
	@Test
	public void testIsDigitsOnlyWithLetters(){
		SudokuVerifier sudoku = new SudokuVerifier();
		
		// Following string has an "A" in the middle.
		String test = "417369825632158947958724316825437169791586432A46912758289643571573291684164875293";
		
		assertFalse(sudoku.isDigitsOnly(test));
	}
}
