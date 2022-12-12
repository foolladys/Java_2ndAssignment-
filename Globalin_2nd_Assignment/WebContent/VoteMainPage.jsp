<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 페이지</title>
<style type="text/css">
	*{margin : 0; padding : 0}
	.header_div{height : 100px; background-color:black; color:white; text-align: center; line-height: 100px;
	border: 1px solid white;}
	header{ font-size: 30px; font-variant : normal; font-weight:900; }
	footer{font-size: 1.2em; font-family: 청소년서체; color : white; background-color : black;}
	section{ height : 500px; background-color: rgba(220,220,220,1.0); color : black; line-height : 500px; text-align: center; font-size: 2.0em;}
	ul {border : 1px solid white; font-size : 1.2em; font-family: 청소년서체;}
	li { display: inline;}
	a { text-decoration: none;}
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
	<p id="mainPageContext">투표 프로그램의 메인 화면입니다.</p>
</section>
<hr>
<footer>
	<div class="footer_div">	
		<p align="center"> 
			<span>글로벌인 IT 빅데이터 3기</span><br>
	 		<span> JSP / SQL / 2nd IT PROJECT </span><br>
	 		<span> by 김형우</span><br>
  		</p>
   </div>
</footer>
</body>
</html>