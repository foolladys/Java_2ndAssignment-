package VoteProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VoteDao {

	private DataSource dataSource = null;

	public VoteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public List<VoteDto> list(){
		ArrayList<VoteDto> vdtos = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			String query= "select * from TBL_VOTE_202212";
			// desc => 내림차순, asc => 오름차순
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int p_Number = rs.getInt("v_jumin"); // 주민번호
				String name = rs.getString("v_name"); // 투표하는사람 이름
				int c_Number = rs.getInt("m_no"); // 후보번호
				int v_Time = rs.getInt("v_time"); // 투표시간(4자리)
				String v_Area = rs.getString("v_area"); // 투표할 장소
				String v_Confirm = rs.getString("v_confirm"); // 유권자 확인
				
				VoteDto vdto = new VoteDto(p_Number, name, c_Number, v_Time, v_Area, v_Confirm);
				
				vdtos.add(vdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
			}
		}	
		return vdtos;
	}
	*/
	public void doVote(String v_jumin, String v_name, String m_no, 
			String v_time, String v_area, String v_confirm){
		
		// System.out.println("doVote() 호출.."); 디버깅 코드
		System.out.println(v_jumin);
		System.out.println(v_name);
		System.out.println(m_no);
		System.out.println(v_time);
		System.out.println(v_area);
		System.out.println(v_confirm);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String query = "insert into tbl_vote_202212" + 
								   "(v_jumin, v_name, m_no, v_time, v_area, v_confirm)" +
			                       "values (?, ?, ?, ?, ?, ?)";
		  
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, v_jumin);
			preparedStatement.setString(2, v_name);
			preparedStatement.setString(3, m_no);
			preparedStatement.setString(4, v_time);
			preparedStatement.setString(5, v_area);
			preparedStatement.setString(6, v_confirm);
			int rn = preparedStatement.executeUpdate();
			System.out.println("업데이트 개수 : " + rn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
			}
		}	
	}
	
	public List<VoteInspectDto> vote_Inspect(){
		ArrayList<VoteInspectDto> vdtos3 = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			String query= "select * from TBL_VOTE_202212";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String p_Number = rs.getString("v_jumin"); // 주민번호

				String birth; // 7번째숫자를 1,2,3,4에 따라서 1900년대생인지 2000년대생인지 확인함
				if(p_Number.substring(6,7).equals("1")) {
					birth = "19" + p_Number.substring(0, 2) + "년" + p_Number.substring(2, 4) + "월" 
							+ p_Number.substring(4, 6) + "일생";
					}
				else if(p_Number.substring(6,7).equals("2")) {
					birth = "19" + p_Number.substring(0, 2) + "년" + p_Number.substring(2, 4) + "월" 
							+ p_Number.substring(4, 6) + "일생";
				}
				else if(p_Number.substring(6,7).equals("3")) {
					birth = "20" + p_Number.substring(0, 2) + "년" + p_Number.substring(2, 4) + "월" 
							+ p_Number.substring(4, 6) + "일생";
				}
				else if(p_Number.substring(6,7).equals("4")) {
					birth = "20" + p_Number.substring(0, 2) + "년" + p_Number.substring(2, 4) + "월" 
							+ p_Number.substring(4, 6) + "일생";
				}else {
					birth = "주민번호 오류";
				}

				String raw_age = rs.getString("v_jumin"); // Database에 저장되어있는 char형 13자리 데이터의 원형
				int converted_age; 
				// integer형으로 변환된 나이 -> 7번째자리를 검사해서 1900년대생이면 123-년대, 2000년대생이면 23-년대로 세팅.
				if(p_Number.substring(6,7).equals("1")) {
					converted_age = 123 - Integer.parseInt(raw_age.substring(0, 2));
					}
				else if(p_Number.substring(6,7).equals("2")) {
					converted_age = 123 - Integer.parseInt(raw_age.substring(0, 2));
				}
				else if(p_Number.substring(6,7).equals("3")) {
					converted_age = 23 - Integer.parseInt(raw_age.substring(0, 2));
				}
				else if(p_Number.substring(6,7).equals("4")) {
					converted_age = 23 - Integer.parseInt(raw_age.substring(0, 2));
				}
				else
				{
					converted_age = 123 - Integer.parseInt(raw_age.substring(0, 2));
				}
				
				String age = converted_age + "세";
				String name = rs.getString("v_name"); // 투표하는사람 이름
				String gender = "";
				if(p_Number.substring(6,7).equals("1")) {
					gender = "남";
				}else if (p_Number.substring(6,7).equals("2")) {
					gender = "여";
				}else if (p_Number.substring(6,7).equals("3")) {
					gender = "남";
				}else if (p_Number.substring(6,7).equals("4")) {
					gender = "여";
				}else {
					gender = "불명";
				}
				
				String c_Number = rs.getString("m_no"); // 후보번호
				String v_Time = rs.getString("v_time"); // 투표시간(4자리)
				String divided_Time = v_Time.substring(0, 2) + ":" + v_Time.substring(2,4);
				
				
				String v_Confirm = rs.getString("v_confirm"); // 유권자 확인
				
				// 성명 - 생년월일 - 나이 - 성별 - 후보번호 - 투표시간 - 유권자확인
				
				VoteInspectDto vdto = new VoteInspectDto(name, birth, age, gender, c_Number , divided_Time ,v_Confirm);
				
				vdtos3.add(vdto);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
			}
		}	
		return vdtos3;
	}
	
	
	public List<VoteRankingDto> vote_rank_listing(){
		ArrayList<VoteRankingDto> vote_rank_list = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			String query= "select m_no, count(*) as voted_count from tbl_vote_202212"
					+ " group by m_no order by voted_count desc";
			// 투표자 테이블에서 후보번호와 투표받은 수를 받아오고, 투표받은 수를 내림차순 정렬시켰다.
			// 후보번호를 받아와서 후보명을 부여해주고, vote_rank_list라는 ArrayList에 삽입시킨 후,
			// 커맨드 객체로 연결시켜 Candidate_Ranking.jsp에서 로드하도록 시킴
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
		
				String c_Number = rs.getString("m_no"); // 후보번호
				String c_name; // 후보 이름
				if(c_Number.equals("1")) {
					c_name = "김후보";
				}else if(c_Number.equals("2")) {
					c_name = "이후보";
				}else if(c_Number.equals("3")) {
					c_name = "박후보";
				}else if(c_Number.equals("4")) {
					c_name = "조후보";
				}else if(c_Number.equals("5")) {
					c_name = "김후보";
				}else {
					c_name = "잘못된 후보명";
				}
				
				int voted_count = rs.getInt("voted_count"); // 투표받은 수
				// 후보번호 - 이름 - 투표받은 수
				
				VoteRankingDto vrdto = new VoteRankingDto(c_Number , c_name, voted_count);
				
				vote_rank_list.add(vrdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
			}
		}	
		return vote_rank_list;
	}
		
}
