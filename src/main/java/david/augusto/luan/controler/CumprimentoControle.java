package david.augusto.luan.controler;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import david.augusto.luan.Cumprimento;

@RestController
public class CumprimentoControle {

	private static final String template = "GHello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/cumprimento")
	public Cumprimento cumprimento(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Cumprimento(counter.incrementAndGet(), String.format(template, name));
	}
}
