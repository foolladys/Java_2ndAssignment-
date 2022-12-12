package VoteProgram;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CandidatesListCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CDao cdao = new CDao();
		
		// 테이블에 있는 모든 데이터를 끌고 온다는 뜻
		List<CDto> cdtos = cdao.modifiedList();
		
		//forwarding될때까지 메모리에 살아있음을 반드시 기억해야한다.
		request.setAttribute("candidates_list", cdtos);
		
	}

}
