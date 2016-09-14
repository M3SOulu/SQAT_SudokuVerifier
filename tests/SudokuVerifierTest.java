import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testCandidateContains_Zero_Err1() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = 
				  "417369825"
				+ "632150947" // Zero
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";;
		assertEquals(-1, verifier.verify(candidate));
	}

	@Test
	public void testCandidateContains_InvalidCharacter_Err1() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = 
				  "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "79158a432" // a
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		assertEquals(-1, verifier.verify(candidate));
	}
	@Test
	public void testCandidateContains_Incorrect_ErrAny() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = 
				  "123456789"
				+ "912345678"
			    + "891234567"
				+ "789123456"
			    + "678912345"
				+ "567891234"
			    + "456789123"
			    + "345678912"
			    + "234567891";
		
		assertNotEquals(0, verifier.verify(candidate));
	}

	@Test
	public void testCandidate_Succ0() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = 
				  "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		
		assertEquals(0, verifier.verify(candidate));
	}

	@Test
	public void testCandidate_Row_Duplicates_Err3() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate =
				  "111111111"
				+ "222222222"
				+ "333333333"
				+ "444444444"
				+ "555555555" // Duplicate = 6
				+ "666666666"
				+ "777777777"
				+ "888888888"
				+ "999999999";
		
		assertEquals(-3, verifier.verify(candidate));
	}
	
	@Test
	public void testCandidate_Column_Duplicates_Err4() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = 
				  "123456789"
				+ "123456789"
				+ "123456789"
				+ "123456789"
				+ "123456789"
				+ "123456789"
				+ "123456789"
				+ "123456789"
				+ "123456789";
		
		assertEquals(-4, verifier.verify(candidate));
	}
	
	//@Test
	//public void testVerify() {
	//	fail("Not yet implemented");
	//}
}
