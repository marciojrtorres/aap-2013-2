package toolkit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

	private List lista;
	
	@Before
	public void inicializa() {
		lista = new List();
		lista.append(1); lista.append(2);
	}
	
	@After
	public void limpa() {
		lista.wipe();
	}
	
	@Test
	public void test_list_com_dois_length_2() {
		assertEquals(2, lista.length());
	}
	
	@Test
	public void test_list_vazia_length_zero() {
		lista.wipe();
		assertEquals(0, lista.length());
	}
	
	@Test
	public void test_drop_um_item_dah_length_um() {
		lista.drop(0);
		assertEquals(1, lista.length());
	}
	
	@Test
	public void test_append_null_nao_insere() {
		assertEquals(2, lista.length());
		lista.append(null);
		assertEquals(2, lista.length());
	}

}
