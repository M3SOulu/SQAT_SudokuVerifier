import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	private SudokuVerifier verifier;
	
	@Before
	public void setup() {
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void testVerify() {
		fail("Not yet implemented");
	}
	
	@Test
	public void rule2CorrectForCorrectSudoku() {
		String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("Failed when checking global rowfor correct sudoku",
				verifier.NO_ERROR, verifier.verifyGlobalRow(correctSudoku));
	}
	
	@Test
	public void rule2CatchesError() {
		String incorrectSudoku = "123456789912345678891234567789123456678912345567891234456782123345678912234567891";
		assertEquals("Global row error was not found when it exists",
				verifier.SUBGRID_ERROR, verifier.verifyGlobalRow(incorrectSudoku));
	}

}
