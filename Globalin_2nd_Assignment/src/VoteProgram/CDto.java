package VoteProgram;

public class CDto {

	private String m_no;
	private String m_name;
	private String p_code;
	private String p_school;
	private String m_jumin;
	private String m_city;
	private int m_voted_count;
	private String president_number;

	public CDto(String m_no, String m_name, String p_code, String p_school, String m_jumin, String m_city) {
		this.m_no = m_no; // 후보번호
		this.m_name = m_name; // 성명
		this.p_code = p_code; // 정당코드 정당번호 P + 숫자 1자리
		this.p_school = p_school; // 최종학력
		this.m_jumin = m_jumin; // 주민번호
		this.m_city = m_city; // 지역구 
	}
	
	public CDto(String m_no, String m_name, String p_code, String p_school, String m_jumin, String m_city, String president_number) {
		this.m_no = m_no; // 후보번호
		this.m_name = m_name; // 성명
		this.p_code = p_code; // 정당코드 정당번호 P + 숫자 1자리
		this.p_school = p_school; // 최종학력
		this.m_jumin = m_jumin; // 주민번호
		this.m_city = m_city; // 지역구 
		this.president_number = president_number;
	}
	
	
	public CDto(String m_no, String m_name, int m_voted_count) {
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_voted_count = m_voted_count;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_school() {
		return p_school;
	}

	public void setP_school(String p_school) {
		this.p_school = p_school;
	}

	public String getM_jumin() {
		return m_jumin;
	}

	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public int getM_voted_count() {
		return m_voted_count;
	}

	public void setM_voted_count(int m_voted_count) {
		this.m_voted_count = m_voted_count;
	}

	public String getPresident_number() {
		return president_number;
	}

	public void setPresident_number(String president_number) {
		this.president_number = president_number;
	}
	
	// 생성자 -> 후보번호, 성명, 정당코드, 최종학력, 주민번호, 지역구
	// 예시) '1', '김후보', 'P1', '1', '6603011999991', '수선화동'
	
	
}
