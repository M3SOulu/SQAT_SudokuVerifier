import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testCandidateContains_Zero_1() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = "417369825632150947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(verifier.verify(candidate), 1);
	}
	
	@Test
	public void testCandidateContains_InvalidCharacter_1() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = "417369825632158947958724316825a37169791586432346912758289643571573291684164875293";
		assertEquals(verifier.verify(candidate), 1);
	}
	
	@Test
	public void testCandidate_0() throws Exception {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidate = "417369825632158947958724s316825437169791586432346912758289643571573291684164875293";
		assertEquals(verifier.verify(candidate), 0);
	}
	
	//@Test
	//public void testVerify() {
	//	fail("Not yet implemented");
	//}
}
