package david.augusto.luan.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	private Date timestamp;
	@Getter
	private String mensagem;
	@Getter
	private String detalhes;

	public ExceptionResponse(Date timestamp, String mensagem, String detalhes) {
		this.timestamp = new Date();
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

}
