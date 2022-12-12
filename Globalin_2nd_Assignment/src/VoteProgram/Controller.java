package VoteProgram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet 호출됨");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost 호출됨");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
	
		System.out.println("actionDo() .. 호출됨");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		VoteCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		//위의 세 줄은 http://localhost:8282/jsp_mvc_board/list.do 에서 list.do를 꺼내기 위한 코드들.
		
		System.out.println("경로 확인:" + uri + ":" + conPath + ":" + com );
	
		if(com.equals("/Candidate_Lookup.do")) {
			command = new CandidatesListCommand();
			command.execute(request, response);
			viewPage ="Candidate_Lookup.jsp";
		}
		else if(com.equals("/doVote.do")) {
			//command = new DoVoteCommand();
			//command.execute(request, response);
			viewPage="doVote.jsp";
		}else if(com.equals("/Vote_Inspect.do")) {
			command = new VoteInspectCommand();
			command.execute(request, response);
			viewPage="Vote_Inspect.jsp";
		}else if(com.equals("/Candidate_Ranking.do")) {
			command = new CandidatesRankingCommand();
			command.execute(request, response);
			viewPage="Candidate_Ranking.jsp";
		}else if(com.equals("/vote_completed.do")) {
			command = new DoVoteCommand();
			command.execute(request, response);
			viewPage="Vote_Inspect.do";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
