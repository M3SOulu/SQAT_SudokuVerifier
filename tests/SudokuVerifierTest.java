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
	public void correctVerify() {
		String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("Failed when checking correct sudoku",
				verifier.NO_ERROR, verifier.verify(correctSudoku));
	}
	
	@Test
	public void incorrectVerify() {
		String incorrectSudoku = "123456789912345678891234567789123456678912345567891234456782123345678912234567891";
		assertFalse("Verified incorrect sudoku",
				verifier.NO_ERROR == verifier.verify(incorrectSudoku));
	}
	
	@Test
	public void rule1CorrectForCorrectSudoku() {
		String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("Failed when checking cell nums 1..9 for correct sudoku",
				verifier.NO_ERROR, verifier.verifyCellValues(correctSudoku));
	}
	
	@Test
	public void rule1CatchesInvalidCharacter() {
		String incorrectSudoku = "417369825632158947958724316825437169791586432346912758289643571573-291684164875293";
		assertEquals("Failed when checking cell nums 1..9 for correct sudoku",
				verifier.DIGIT_ERROR, verifier.verifyCellValues(incorrectSudoku));
	}
	
	@Test
	public void rule1CatchesInvalidNumberZero() {
		String incorrectSudoku = "4173698256321589479587243168254371697915864323469127582896435715730291684164875293";
		assertEquals("Failed when checking cell nums 1..9 for correct sudoku",
				verifier.DIGIT_ERROR, verifier.verifyCellValues(incorrectSudoku));
	}
	
	@Test
	public void rule2CorrectForCorrectSudoku() {
		String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("Failed when checking subgrid nums 1..9 for correct sudoku",
				verifier.NO_ERROR, verifier.verifySubGrid(correctSudoku));
	}
	
	@Test
	public void rule2CatchesError() {
		String incorrectSudoku = "417369825"
							   + "632158947"
							   + "958724316"
							   
							   + "825437169"
							   + "791586432"
							   + "346932758" // second 3 in middle subgrid
							   
							   + "289643571"
							   + "573291684"
							   + "164875293";
		assertEquals("Erratic subgrid was not found",
				verifier.SUBGRID_ERROR, verifier.verifySubGrid(incorrectSudoku));
	}
	
	@Test
	public void rule3CorrectForCorrectSudoku() {
		String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("Failed when checking global row for correct sudoku",
				verifier.NO_ERROR, verifier.verifyGlobalRow(correctSudoku));
	}
	
	@Test
	public void rule3CatchesError() {
		String incorrectSudoku = "123456789912345678891234567789123456678912345567891234456782123345678912234567891";
		assertEquals("Global row error was not found when it exists",
				verifier.GLOBAL_ROW_ERROR, verifier.verifyGlobalRow(incorrectSudoku));
	}
	
	@Test
	public void rule4CorrectForCorrectSudoku() {
		String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("Failed when checking global row for correct sudoku",
				verifier.NO_ERROR, verifier.verifyGlobalColumn(correctSudoku));
	}
	
	@Test
	public void rule4CatchesError() {
		String incorrectSudoku = "123456789"
							   + "912345678"
							   + "891234567"
							   + "789123456"
							   + "678912345"
							   + "567891234"
							   + "456782123"
							   + "345678912"
							   + "234567891";
		assertEquals("Erratic global column was not found",
				verifier.GLOBAL_COLUMN_ERROR, verifier.verifyGlobalColumn(incorrectSudoku));
	}
	
	//verifier.SUBGRID_ERROR, verifier.verifyGlobalRow(incorrectSudoku));

}
