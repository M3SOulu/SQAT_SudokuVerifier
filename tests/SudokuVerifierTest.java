import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testCandidateContains_Zero_1() throws Exception {
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
		assertEquals(1, verifier.verify(candidate));
	}
	
	@Test
	public void testCandidateContains_InvalidCharacter_1() throws Exception {
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
		assertEquals(1, verifier.verify(candidate));
	}

	@Test
	public void testCandidate_0() throws Exception {
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
	public void testCandidate_Row_Duplicates_3() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate =
				  "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586632" // Duplicate = 6
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		
		assertEquals(3, verifier.verify(candidate));
	}
	
	@Test
	public void testCandidate_Column_Duplicates_4() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate =
				String candidate = 
				  "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586431"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		
		assertEquals(4, verifier.verify(candidate));
	}
	
	//@Test
	//public void testVerify() {
	//	fail("Not yet implemented");
	//}
}
