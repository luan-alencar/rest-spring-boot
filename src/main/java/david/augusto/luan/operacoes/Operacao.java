package david.augusto.luan.operacoes;

public class Operacao {

	public static Double soma(Double numero1, Double numero2) {
		return numero1 + numero2;
	}

	public static Double subtracao(Double numero1, Double numero2) {
		return numero1 - numero2;
	}


	public static Double divisao(Double numero1, Double numero2) {
		return numero1 / numero2;
	}

	public static Double multiplicacao(Double numero1, Double numero2) {
		return numero1 * numero2;
	}

	public static Double media(Double numero1, Double numero2) {
		return (numero1 + numero2) / 2;
	}

	public static Double raiz(Double numero1) {
		return (Double) Math.sqrt(numero1);
	}
}
