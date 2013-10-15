package cobaia;

import toolkit.ObjectFilter;
import static toolkit.StringUtil.trim;

public class FiltraStringComEspacos
			implements ObjectFilter<String> {

	@Override
	public boolean isInvalid(String o) {		
		if (o == null) return true;
		if (o.trim().length() == 0) return true;		
		return false;
	}

}
