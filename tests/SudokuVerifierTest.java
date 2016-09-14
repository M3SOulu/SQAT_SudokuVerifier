import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_TooShortString() {
		String testString = "123";
		SudokuVerifier.verify(testString);
		assertEquals("String is too short", -1,SudokuVerifier.verify(testString));
	}
	
	@Test
	public void testVerify_StringLengthIsEnough() {
		String testString = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		SudokuVerifier.verify(testString);
		assertEquals("String lenght is incorrect", 0,SudokuVerifier.verify(testString));
	}
	
	@Test
	public void testVerify_StringIsTooLong() {
		String testString = "41736982563215894795872431682543716979158643234691275828964312313123123312571573291684164875293";
		SudokuVerifier.verify(testString);
		assertEquals("String is too long", -1,SudokuVerifier.verify(testString));
	}
	
	@Test
	public void testVerify_splitIntoRowsOfNine() {
		String testString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier.amountOfRows(testString);
		assertEquals("There are not 9 rows", 0, SudokuVerifier.amountOfRows(testString));
	}
	

}
