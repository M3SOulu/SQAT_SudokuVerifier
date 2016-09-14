import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_CorrectSolution() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Correct solution", 0, verification);
	}

	@Test
	public void testVerify_IncorrectSolution() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "123456789"
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
		String solution = ""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "1648752931"; // Extra number
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act, should raise an exception
		int verification = SudokuVerifier.verify(solution);
	}
	
	@Test
	public void testVerify_IncorrectNumbers() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875290"; // 0 at the end
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Incorrect numbers", -1, verification);
	}
	
	@Test
	public void testVerify_IncorrectCharacters() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875abc"; // "abc" at the end
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Incorrect characters", -1, verification);
	}
	
	@Test
	public void testVerify_SameNumbersInASubgrid() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "417369825" // 4 in the leftmost subgrid
				+ "632158947"
				+ "458724316" // 4 in the leftmost subgrid
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Same numbers in a row", -2, verification);
	}
	
	@Test
	public void testVerify_SameNumbersInARow() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "617369825" // Two 6's
				+ "432158947" // Two 4's
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Same numbers in a row", -3, verification);
	}
	
	@Test
	public void testVerify_SameNumbersInAColumn() throws IllegalArgumentException {
		// Arrange
		String solution = ""
				+ "417369825" // 5 at the end
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912785" // 5 at the end
				+ "289643571"
				+ "573291684"
				+ "164875293";
		SudokuVerifier SudokuVerifier = new SudokuVerifier();
		
		// Act
		int verification = SudokuVerifier.verify(solution);
		
		// Assert
		assertEquals("Same numbers in a column", -4, verification);
	}
}
