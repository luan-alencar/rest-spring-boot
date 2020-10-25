package david.augusto.luan.controler;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatematicaControle {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/soma/numeroUm/numeroDois", method = RequestMethod.GET)
	public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {

		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new Exception();
		}
		Double soma = converterParaDouble(numeroUm) + converterParaDouble(numeroDois);
		return soma;
	}

	private Double converterParaDouble(String numeroDois) {
		return 1D;
	}

	private boolean isNumero(String numero) {
		return false;
	}
}
