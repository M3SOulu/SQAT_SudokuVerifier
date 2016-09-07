import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testCorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0, returnCode);
	}
	
	@Test
	public void testIncorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		assertEquals(-2, returnCode);
	}
	
	@Test
	public void testIncorrect_Rule1() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "79158asd2" //here
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293");
		assertEquals(-1, returnCode); //Only numbers
	}
	
	@Test
	public void testIncorrect_Rule2() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291685" //here
				+ "164875293");
		assertEquals(-2, returnCode); //No repeating in sub-grid
	}
	
	@Test
	public void testIncorrect_Rule3() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158917" //here
				+ "958724346"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293");
		assertEquals(-3, returnCode); //No repeating in a row
	}
	
	@Test
	public void testIncorrect_Rule4() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "537291684" //here
				+ "164875293");
		assertEquals(-4, returnCode); //No repeating in a column
	}
}
