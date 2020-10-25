package david.augusto.luan;

public class Cumprimento {

	private final Long id;
	private final String content;

	public Cumprimento(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
