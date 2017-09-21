import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTranslatorImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRomanConversion() {

	    for (int i = 1; i<= 100; i++) {
	        System.out.println(i+"\t =\t "+ RomanNumeralTranslatorImpl.toRoman(i));
	    }

	}
}
