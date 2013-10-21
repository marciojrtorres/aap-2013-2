package cobaia;

import toolkit.FilteredListTemplate;

public class ListClienteValido 
	extends FilteredListTemplate<Cliente> {

	@Override
	protected boolean accept(Cliente o) {
		return o.getCodigo() > 0;
	}

}
