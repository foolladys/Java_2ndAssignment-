package VoteProgram;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteInspectCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao vidao = new VoteDao();
		
		List<VoteInspectDto> vidtos = vidao.vote_Inspect();
		
		request.setAttribute("vote_inspect_list", vidtos);
		
	}

}
