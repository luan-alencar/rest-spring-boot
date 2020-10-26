package david.augusto.luan.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import david.augusto.luan.model.Pessoa;

@Service // o spring vai cuidar da injeçao de dependencias nessa classe cm o @Service
public class PessoaServico {

	@Autowired
	private final AtomicLong counter = new AtomicLong();

	public Pessoa findById(String id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet()); // incrementAndGet vai pegar um numero do id e incrementa-lo
		pessoa.setPrimeiroNome("Luan");
		pessoa.setUltimoNome("Augusto");
		pessoa.setEndereco("Campina Grande - Paraiba - Brasil");
		return pessoa;
	}
}
