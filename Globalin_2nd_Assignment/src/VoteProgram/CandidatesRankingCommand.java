package VoteProgram;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CandidatesRankingCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao vdao = new VoteDao();
		// 테이블에 있는 모든 데이터를 끌고 온다는 뜻
		List<VoteRankingDto> vote_rank_list = vdao.vote_rank_listing();
		//forwarding될때까지 메모리에 살아있음을 반드시 기억해야한다.
		request.setAttribute("vote_rank_list", vote_rank_list);
		
	}

}
