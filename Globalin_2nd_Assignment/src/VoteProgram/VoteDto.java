package VoteProgram;

public class VoteDto {

	private String p_Number; // 주민번호 (13자리)  people number
	private String name; // 이름
	private String c_Number; // 후보번호 (1자리) candidate number
	private String v_Time; // 투표시간 (4자리) vote time
	private String v_Area; // 투표 장소 (20자리) vote area
	private String v_Confirm; // 유권자 확인 (1자리) Y/N만 담아둘 변수
	
	//생성자 -> 주민번호, 이름, 후보번호, 투표시간, 투표장소, 유권자 확인 순
	
	public VoteDto () {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getP_Number() {
		return p_Number;
	}

	public void setP_Number(String p_Number) {
		this.p_Number = p_Number;
	}

	public String getC_Number() {
		return c_Number;
	}

	public void setC_Number(String c_Number) {
		this.c_Number = c_Number;
	}

	public String getV_Time() {
		return v_Time;
	}

	public void setV_Time(String v_Time) {
		this.v_Time = v_Time;
	}

	public String getV_Area() {
		return v_Area;
	}

	public void setV_Area(String v_Area) {
		this.v_Area = v_Area;
	}

	public String getV_Confirm() {
		return v_Confirm;
	}

	public void setV_Confirm(String v_Confirm) {
		this.v_Confirm = v_Confirm;
	}

	public VoteDto(String p_Number, String name, String c_Number, String v_Time, String v_Area, String v_Confirm) {
		this.p_Number = p_Number;
		this.name = name;
		this.c_Number = c_Number;
		this.v_Time = v_Time;
		this.v_Area = v_Area;
		this.v_Confirm = v_Confirm;
	}
	// 투표하는 사람들 객체
	
	
}
