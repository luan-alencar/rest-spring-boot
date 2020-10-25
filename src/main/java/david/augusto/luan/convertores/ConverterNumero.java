package david.augusto.luan.convertores;

import david.augusto.luan.utils.IsNumero;

public class ConverterNumero {

	public static Double converterParaDouble(String strNumero) {
		if (strNumero == null)
			return 0D;
		String numero = strNumero.replaceAll(",", ".");
		if (IsNumero.isNumero(numero))
			return Double.parseDouble(numero);
		return 0D;
	}
}
