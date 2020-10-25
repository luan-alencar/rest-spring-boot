package david.augusto.luan.controler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import david.augusto.luan.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

	// metodo de adicao
	@RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double soma = converterParaDouble(numeroUm) + converterParaDouble(numeroDois);
		return soma;
	}

	// metodo de subtracao
	@RequestMapping(value = "/subtracao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double subtracao = converterParaDouble(numeroUm) - converterParaDouble(numeroDois);
		return subtracao;
	}

	// metodo de multiplicacao
	@RequestMapping(value = "/multiplicacao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numeroUm") String numeroUm,
			@PathVariable("numeroDois") String numeroDois) throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double multiplicacao = converterParaDouble(numeroUm) * converterParaDouble(numeroDois);
		return multiplicacao;
	}

	// metodo de divisao
	@RequestMapping(value = "/divisao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double divisao = converterParaDouble(numeroUm) / converterParaDouble(numeroDois);
		return divisao;
	}

	// metodo de raiz quadrada
	@RequestMapping(value = "/raiz/{numero}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numero") String numero) throws Exception {
		if (!isNumero(numero))
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");

		Double raiz = Math.sqrt(converterParaDouble(numero));
		return raiz;
	}

	private Double converterParaDouble(String strNumero) {
		if (strNumero == null)
			return 0D;
		String numero = strNumero.replaceAll(",", ".");
		if (isNumero(numero))
			return Double.parseDouble(numero);
		return 0D;
	}

	private boolean isNumero(String strNumero) {
		if (strNumero == null)
			return false;
		String numero = strNumero.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	// metodo extraido
	private void ifNotNumber(String numeroUm, String numeroDois) {
		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");
		}
	}
}
