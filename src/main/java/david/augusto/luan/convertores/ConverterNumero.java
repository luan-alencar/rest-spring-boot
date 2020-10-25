package david.augusto.luan.convertores;

public class ConverterNumero {

	public static Double converterParaDouble(String strNumero) {
		if (strNumero == null)
			return 0D;
		String numero = strNumero.replaceAll(",", ".");
		if (isNumero(numero))
			return Double.parseDouble(numero);
		return 0D;
	}

	public static boolean isNumero(String strNumero) {
		if (strNumero == null)
			return false;
		String numero = strNumero.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
