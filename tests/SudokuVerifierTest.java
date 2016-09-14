import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_CorrectSolution() throws IllegalArgumentException {
		// Arrange
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Correct solution", 0, verification);
	}

	@Test
	public void testVerify_IncorrectSolution() throws IllegalArgumentException {
		// Arrange
		String solution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		//assertEquals("Incorrect solution", -3, verification);
		fail("Incorrect solution test not yet implemented");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testVerify_TooShortSolution() throws IllegalArgumentException {
		// Arrange
		String solution = "123456789";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act, should raise an exception
		int verification = SudokuVerifier.verify(solution);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testVerify_TooLongSolution() throws IllegalArgumentException {
		// Arrange
		String solution = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act, should raise an exception
		int verification = SudokuVerifier.verify(solution);
	}
	
	@Test
	public void testVerify_IncorrectNumbers() throws IllegalArgumentException {
		// Arrange
		String solution = "003456789912345678891234567789123456678912345567891234456789123345678912234567890";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Correct solution", -1, verification);
	}
	
	@Test
	public void testVerify_IncorrectCharacters() throws IllegalArgumentException {
		// Arrange
		String solution = "1234567899123456788912345677891234566789123455678912344567891233456789122345abCD-";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Correct solution", -1, verification);
	}
	
	@Test
	public void testVerify_SameNumbersInARow() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "123356789" // two 3's
				+ "912345678"
				+ "891234567"
				+ "789123456"
				+ "678912345"
				+ "567891234"
				+ "456789123"
				+ "345678912"
				+ "234567891";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Correct solution", -3, verification);
	}
}
