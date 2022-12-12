<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자 조회 페이지</title>
<style type="text/css">
	*{margin : 0; padding : 0}
	.header_div{height : 100px; background-color:black; color:white; text-align: center; line-height: 100px;
	border: 1px solid white;}
	header{ font-size: 30px; font-variant : normal; font-weight:900; }
	footer{font-size: 1.2em; font-family: 청소년서체; color : white; background-color : black;}
	section{align : center; background-color: rgba(220,220,220,1.0); color : black; text-align: center; font-size: 2.0em;}
	ul {border : 1px solid white; font-size : 1.2em; font-family: 청소년서체;}
	li { display: inline;}
	a { text-decoration: none;}
	tr { text-align : center ;}
	td { text-align : center;}
	table { height : 300px; width : 700px; text-align : center; align : center; border : solid 1px;}
	article {height: 350px;}
</style>
</head>
<body>
<header>
	<div class="header_div">
	<p align="center"> 지역구의원 투표 프로그램 ver 2022-12 </p>
	</div>
</header>
<hr>
<nav>
	<ul id="menu">
		<li><a href="Candidate_Lookup.do">후보조회</a></li> |
		<li><a href="doVote.do">투표하기</a></li> |
		<li><a href="Vote_Inspect.do">투표검수조회</a></li> |
		<li><a href="Candidate_Ranking.do">후보자등수</a></li> |
		<li><a href="VoteMainPage.jsp">투표 메인 페이지</a></li> |
		<li><a href="index.jsp">메인 페이지</a></li>
	</ul>
</nav>
<hr>
<section>
	<h1 align="center">후보 조회</h1>
</section>
<hr>
<article>
<table border="1" style="margin : 0 auto">
	<tr>
		<td>후보번호</td>
		<td>성명</td>
		<td>소속정당</td>
		<td>학력</td>
		<td>주민번호</td>
		<td>지역구</td>
		<td>대표번호</td>
	</tr>

 <c:forEach var="candidates" items="${candidates_list}">
  	<tr>
 		<td>${candidates.m_no}</td>
 		<td>${candidates.m_name}</td>
 		<td>${candidates.p_code}</td>
 		<td>${candidates.p_school}</td>
 		<td>${candidates.m_jumin}</td>
 		<td>${candidates.m_city}</td>
 		<td>${candidates.president_number}</td>
 	</tr>
 </c:forEach>
  <tr>
 	<td colspan="7"><a href="VoteMainPage.jsp">전 페이지로 돌아가기</a></td>
 </tr>
 
</table>
</article>
<hr>
<footer>
	<div class="footer_div">	
		<p align="center"> 
			<span>글로벌인 IT 빅데이터 3기</span><br>
	 		<span>JSP / 2nd IT PROJECT /</span><br>
	 		<span> by 김형우</span><br>
  		</p>
   </div>
</footer>
</body>
</html>