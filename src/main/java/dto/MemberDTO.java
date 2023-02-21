package dto;

public class MemberDTO {
	private String memId;
	private String memPw;
	private String memName;
	private String regDate;
	private String memGender;
	private String memIntro;
	
	public MemberDTO() {
		
	}

	public MemberDTO(String memId, String memPw, String memName, String regDate, String memGender, String memIntro) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.regDate = regDate;
		this.memGender = memGender;
		this.memIntro = memIntro;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemIntro() {
		return memIntro;
	}

	public void setMemIntro(String memIntro) {
		this.memIntro = memIntro;
	}
	
	
	
}
