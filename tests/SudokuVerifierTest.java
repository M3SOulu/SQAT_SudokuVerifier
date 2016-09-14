import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 1234567899123456788912345677891234566789123455678912344567891233456789122345678912
	
	
	@Test
	public void testStringLengthIsTooLong(){
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String candidateSolution = "1234567899123456788912345677891234566789123455678912344567891233456789122345678912";
		sudoku.checkSudokuLength(candidateSolution);
		
		

	}
	
	@Test
	public void testVerify() {
		fail("Not yet implemented");
	}
}
