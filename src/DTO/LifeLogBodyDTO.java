package DTO;

public class LifeLogBodyDTO {
	
	private String llbId;
	private String llIdFk;
	private String body;
	private String seq;
	
	public LifeLogBodyDTO() {
		// TODO Auto-generated constructor stub
	}

	public LifeLogBodyDTO(String llbId, String llIdFk, String body, String seq) {
		super();
		this.llbId = llbId;
		this.llIdFk = llIdFk;
		this.body = body;
		this.seq = seq;
	}

	public String getLlbId() {
		return llbId;
	}

	public void setLlbId(String llbId) {
		this.llbId = llbId;
	}

	public String getLlIdFk() {
		return llIdFk;
	}

	public void setLlIdFk(String llIdFk) {
		this.llIdFk = llIdFk;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "LifeLogBodyDTO [llbId=" + llbId + ", llIdFk=" + llIdFk
				+ ", body=" + body + ", seq=" + seq + "]";
	}
}
