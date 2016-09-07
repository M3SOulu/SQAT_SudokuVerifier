import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_TooShortString() {
		String testString = "123";
		SudokuVerifier.verify(testString);
		assertEquals("Not yet implemented", 1,SudokuVerifier.verify(testString));
	}
	
	@Test
	public void testVerify_StringLengthIsEnough() {
		String testString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier.verify(testString);
		assertEquals("Not yet implemented", 0,SudokuVerifier.verify(testString));
	}

}
