package david.augusto.luan.utils;

public class IsNumero {

	public static boolean isNumero(String strNumero) {
		if (strNumero == null)
			return false;
		String numero = strNumero.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
