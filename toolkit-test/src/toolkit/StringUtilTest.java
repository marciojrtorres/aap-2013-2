package toolkit;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

// nome da classe de teste: ClasseSendoTestadaTest
public class StringUtilTest {

	// métodos de teste: devem ser dissertativos
	
	@Test
	public void teste_upper_char_a_para_A() {		
		// assertiva (previsão, afirmativa)
		// Assert.assertEquals('A', StringUtil.upper('a'));
		assertEquals('A', StringUtil.upper('a'));
	}
	
	@Test
	public void teste_upper_texto_para_TEXTO() {
		// assertEquals("TEXTO", StringUtil.upper("texto"));
		assertTrue(StringUtil.upper("texto").equals("TEXTO"));
	}
	
	@Test
	public void teste_upper_de_null_dah_null() {
		assertNull(StringUtil.upper(null));
	}
	
	// espera-se uma exceção
	@Test(expected=NullPointerException.class)
	public void teste_trim_de_null_dah_NPE() {
		StringUtil.trim(null);
	}
	
	@Test
	public void teste_trim_texto_entre_espacos_fica_texto() {
		assertEquals("texto", StringUtil.trim(" texto "));		
	}
		
}
