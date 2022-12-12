package VoteProgram;

public class VoteRankingDto {

	private String candidate_number;
	private String name;
	private int voted_count;
	
	public VoteRankingDto() {};
	
	public VoteRankingDto(String candidate_number, String name, int voted_count) {
		this.candidate_number = candidate_number;
		this.name = name;
		this.voted_count = voted_count;
	}


	public String getCandidate_number() {
		return candidate_number;
	}
	public void setCandidate_number(String candidate_number) {
		this.candidate_number = candidate_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVoted_count() {
		return voted_count;
	}
	public void setVoted_count(int voted_count) {
		this.voted_count = voted_count;
	}
	
	
}
