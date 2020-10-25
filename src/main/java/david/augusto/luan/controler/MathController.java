package david.augusto.luan.controler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import david.augusto.luan.convertores.ConverterNumero;
import david.augusto.luan.exception.UnsuportedMathOperationException;
import david.augusto.luan.utils.IsNumero;

@RestController
public class MathController {

	// metodo de adicao
	@RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double soma = ConverterNumero.converterParaDouble(numeroUm) + ConverterNumero.converterParaDouble(numeroDois);
		return soma;
	}

	// metodo de subtracao
	@RequestMapping(value = "/subtracao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double subtracao = ConverterNumero.converterParaDouble(numeroUm) - ConverterNumero.converterParaDouble(numeroDois);
		return subtracao;
	}

	// metodo de multiplicacao
	@RequestMapping(value = "/multiplicacao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numeroUm") String numeroUm,
			@PathVariable("numeroDois") String numeroDois) throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double multiplicacao = ConverterNumero.converterParaDouble(numeroUm) * ConverterNumero.converterParaDouble(numeroDois);
		return multiplicacao;
	}

	// metodo de divisao
	@RequestMapping(value = "/divisao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		Double divisao = ConverterNumero.converterParaDouble(numeroUm) / ConverterNumero.converterParaDouble(numeroDois);
		return divisao;
	}

	// metodo de calcular a media
	@RequestMapping(value = "/media/{numero1}/{numero2}/{numero3}", method = RequestMethod.GET)
	public Double media(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2,
			@PathVariable("numero3") String numero3) throws Exception {
		if (!isNumero(numero1) || !isNumero(numero2) || !isNumero(numero3))
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");
		Double media = ((ConverterNumero.converterParaDouble(numero1) + ConverterNumero.converterParaDouble(numero2)
				+ ConverterNumero.converterParaDouble(numero3)) / 3);

		return media;
	}

	// metodo de raiz quadrada
	@RequestMapping(value = "/raiz/{numero}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numero") String numero) throws Exception {
		if (!IsNumero.isNumero(numero))
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");

		Double raiz = Math.sqrt(ConverterNumero.converterParaDouble(numero));
		return raiz;
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
