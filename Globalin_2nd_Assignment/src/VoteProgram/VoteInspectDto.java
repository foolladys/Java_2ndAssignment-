package VoteProgram;

public class VoteInspectDto {
	
	private String name;
	private String birth;
	private String age;
	private String gender;
	private String candidate_number;
	private String voted_time;
	private String v_confirm;
	
	public VoteInspectDto(String name, String birth, String age, String gender, String candidate_number, String voted_time,
			String v_confirm) {
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.gender = gender;
		this.candidate_number = candidate_number;
		this.voted_time = voted_time;
		this.v_confirm = v_confirm;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCandidate_number() {
		return candidate_number;
	}
	public void setCandidate_number(String candidate_number) {
		this.candidate_number = candidate_number;
	}
	public String getVoted_time() {
		return voted_time;
	}
	public void setVoted_time(String voted_time) {
		this.voted_time = voted_time;
	}
	public String getV_confirm() {
		return v_confirm;
	}
	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	
	
	
}
