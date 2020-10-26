package david.augusto.luan.controler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import david.augusto.luan.convertores.ConverterNumero;
import david.augusto.luan.exception.UnsuportedMathOperationException;
import david.augusto.luan.operacoes.Operacao;

@RestController
public class PessoaController {

	// metodo de adicao
	@RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		return Operacao.soma(ConverterNumero.converterParaDouble(numeroUm),
				ConverterNumero.converterParaDouble(numeroDois));
	}

	// metodo de subtracao
	@RequestMapping(value = "/subtracao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		return Operacao.subtracao(ConverterNumero.converterParaDouble(numeroUm),
				ConverterNumero.converterParaDouble(numeroDois));

	}

	// metodo de multiplicacao
	@RequestMapping(value = "/multiplicacao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numeroUm") String numeroUm,
			@PathVariable("numeroDois") String numeroDois) throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		return Operacao.multiplicacao(ConverterNumero.converterParaDouble(numeroUm),
				ConverterNumero.converterParaDouble(numeroDois));
	}

	// metodo de divisao
	@RequestMapping(value = "/divisao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {
		// metodo extraido
		ifNotNumber(numeroUm, numeroDois);
		return Operacao.divisao(ConverterNumero.converterParaDouble(numeroUm),
				ConverterNumero.converterParaDouble(numeroDois));
	}

	// metodo de calcular a media
	@RequestMapping(value = "/media/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double media(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2)
			throws Exception {
		// metodo estraido
		ifNotNumber(numero1, numero2);
		return Operacao.media(ConverterNumero.converterParaDouble(numero1),
				ConverterNumero.converterParaDouble(numero2));
	}

	// metodo de raiz quadrada
	@RequestMapping(value = "/raiz/{numero}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numero") String numero) throws Exception {
		if (!ConverterNumero.isNumero(numero))
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");
		return Operacao.raiz(Math.sqrt(ConverterNumero.converterParaDouble(numero)));
	}

	// metodo extraido
	public static void ifNotNumber(String numeroUm, String numeroDois) {
		if (!ConverterNumero.isNumero(numeroUm) || !ConverterNumero.isNumero(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");
		}
	}
}
