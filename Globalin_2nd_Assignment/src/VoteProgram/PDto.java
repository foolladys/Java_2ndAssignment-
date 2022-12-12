package VoteProgram;

import java.sql.Timestamp;

public class PDto {
	private String p_Code;
	private String p_Name;
	private Timestamp date;
	private String name;
	private int tel1;
	private int tel2;
	private int tel3;

	public PDto(String p_Code, String p_Name, Timestamp date, String name, int tel1, int tel2, int tel3) {
		this.p_Code = p_Code;
		this.p_Name = p_Name;
		this.date = date;
		this.name = name;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
	}

	public String getP_Code() {
		return p_Code;
	}

	public void setP_Code(String p_Code) {
		this.p_Code = p_Code;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTel1() {
		return tel1;
	}

	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}

	public int getTel2() {
		return tel2;
	}

	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}

	public int getTel3() {
		return tel3;
	}

	public void setTel3(int tel3) {
		this.tel3 = tel3;
	}

	// 정당코드 테이블 객체
}
