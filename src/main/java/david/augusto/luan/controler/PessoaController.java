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
		if (!ConverterNumero.isNumero(numeroUm) || !ConverterNumero.isNumero(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor, insira um numero valido");
		}
		return Operacao.soma(ConverterNumero.converterParaDouble(numeroUm),
				ConverterNumero.converterParaDouble(numeroDois));
	}
}
