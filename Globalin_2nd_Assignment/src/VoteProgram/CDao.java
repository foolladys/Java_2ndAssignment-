package VoteProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 후보자 리스트 뽑는 클래스

public class CDao {
	
		private DataSource dataSource = null;
		
		public CDao() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public List<CDto> list(){
			ArrayList<CDto> cdtos = new ArrayList<>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
			try {
				String query= "select * from tbl_member_202212 order by m_no asc";
				// desc => 내림차순, asc => 오름차순
				connection = dataSource.getConnection();
				preparedStatement = connection.prepareStatement(query);
				rs = preparedStatement.executeQuery();
				
				// 생성자 -> 후보번호, 성명, 정당코드, 최종학력, 주민번호, 지역구
				// 예시) '1', '김후보', 'P1', '1', '6603011999991', '수선화동'
				
				while(rs.next()) {
					String m_no = rs.getString("m_no");
					String m_name = rs.getString("m_name");
					String p_code = rs.getString("p_code");
					String p_school = rs.getString("p_school");
					String p_school_kor = null;
					
					if(p_school.equals("1")) {
						p_school_kor = "고졸";
					}
					else if(p_school.equals("2")) {
						p_school_kor = "학사";
					}
					else if(p_school.equals("3")) {
						p_school_kor = "석사";
					}
					else if(p_school.equals("4")) {
						p_school_kor = "박사";
					}
					String m_jumin = rs.getString("m_jumin"); 
					String modified_m_jumin = m_jumin.substring(0, 6) + "-" + m_jumin.substring(6);
					
					String m_city = rs.getString("m_city");
					
					CDto cdto = new CDto(m_no, m_name, p_code, p_school_kor, modified_m_jumin, m_city);
					
					cdtos.add(cdto);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(rs != null) rs.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}	
			
			return cdtos;
			
		}
		
		public List<CDto> rank(){
			ArrayList<CDto> cdtos2 = new ArrayList<>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
			try {
				String query= "select * from tbl_member_202212 order by m_no asc";
				// desc => 내림차순, asc => 오름차순
				connection = dataSource.getConnection();
				preparedStatement = connection.prepareStatement(query);
				rs = preparedStatement.executeQuery();
				
				// 생성자 -> 후보번호, 성명, 정당코드, 최종학력, 주민번호, 지역구
				// 예시) '1', '김후보', 'P1', '1', '6603011999991', '수선화동'
				
				while(rs.next()) {
					String m_no = rs.getString("m_no");
					String m_name = rs.getString("m_name");
					int m_voted_count = rs.getInt("m_voted_count");
					
					CDto cdto = new CDto(m_no, m_name, m_voted_count);
					
					cdtos2.add(cdto);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(rs != null) rs.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}	
			
			return cdtos2;
			
		}
		
		
		public List<CDto> modifiedList(){
			ArrayList<CDto> cdtos = new ArrayList<>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
			try {
				String query= "select m_no, m_name, "
						+ "decode(cand.p_code, 'P1', 'A정당', 'P2', 'B정당', 'P3', 'C정당', 'P4', 'D정당', 'P5', 'E정당') as\r\n" + 
						"소속정당, decode(p_school, 1, '고졸', 2, '학사', 3, '석사', 4, '박사') "
						+ "as 학력, m_jumin, m_city, p_tel1 ||'-'|| p_tel2 || '-' || p_tel3 as "
						+ "대표전화 from tbl_member_202212 cand, tbl_party_202212 party where cand.p_code = party.p_code";
				
				connection = dataSource.getConnection();
				preparedStatement = connection.prepareStatement(query);
				rs = preparedStatement.executeQuery();
				
				// 생성자 -> 후보번호, 성명, 정당코드, 최종학력, 주민번호, 지역구
				// 예시) '1', '김후보', 'P1', '1', '6603011999991', '수선화동'
				
				while(rs.next()) {
					String m_no = rs.getString("m_no");
					String m_name = rs.getString("m_name");
					String p_code = rs.getString("소속정당");
					String p_school = rs.getString("학력");
					String m_jumin = rs.getString("m_jumin"); 
					String modified_m_jumin = m_jumin.substring(0, 6) + "-" + m_jumin.substring(6);
					String m_city = rs.getString("m_city");
					String president_number = rs.getString("대표전화");
					
					CDto cdto = new CDto(m_no, m_name, p_code, p_school, modified_m_jumin, m_city, president_number);
					
					cdtos.add(cdto);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(rs != null) rs.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}	
			
			return cdtos;
			
		}
}
