import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	private SudokuVerifier verifier;
	
	public void Setup() {
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void testVerify_withCorrectLength() {
		Setup();
		int result = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertThat(result, is(0));
	}
	
	@Test
	public void testVerify_with80Chars() {
		Setup();
		int result = verifier.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529");
		assertThat(result, anyOf(is(-1), is(-2),is(-3),is(-4)));
	}
	
	@Test
	public void testVerify_with82Chars() {
		Setup();
		int result = verifier.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752933");
		assertThat(result, anyOf(is(-1), is(-2),is(-3),is(-4)));
	}
	
	@Test
	public void testR1_verifyWithIncorrectSymbols() {
		Setup();
		int result = verifier.verify("41a369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(result, -1);
	}
	
	@Test
	public void testR2_verifyWithIncorrectSubgrids() {
		Setup();
		int result = verifier.verify("417777775632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(result, -2);
	}

	
}
