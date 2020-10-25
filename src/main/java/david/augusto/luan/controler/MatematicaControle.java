package david.augusto.luan.controler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatematicaControle {

	@RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {

		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new Exception();
		}
		Double soma = converterParaDouble(numeroUm) + converterParaDouble(numeroDois);
		return soma;
	}

	private Double converterParaDouble(String strNumero) {
		if (strNumero == null)
			return 0D;
		String numero = strNumero.replaceAll(",", ".");
		if (isNumero(numero))
			return Double.parseDouble(numero);
		return 1D;
	}

	private boolean isNumero(String strNumero) {
		if (strNumero == null)
			return false;
		String numero = strNumero.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
