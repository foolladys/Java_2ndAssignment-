<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<style type="text/css">
	*{margin : 0; padding : 0}
	.header_div{height : 100px; background-color:black; color:white; text-align: center; line-height: 100px;
	border: 1px solid white;}
	header{ font-size: 30px; font-variant : normal; font-weight:900; }
	footer{font-size: 1.2em; font-family: 청소년서체; color : white; background-color : black;}
	section{ background-color: rgba(220,220,220,1.0); color : black; text-align: center; font-size: 2.0em;}
	ul {border : 1px solid white; font-size : 1.2em; font-family: 청소년서체;}
	li { display: inline;}
	a { text-decoration: none;}
	article {height: 350px;}
	table { height : 400px; width : 700px; text-align : center; align : center; border : solid 1px;}
</style>
<script>
	 function nullcheck(){
		 var form = document.vote_form;
		 if(form.v_jumin.value == "") {
			 alert("주민번호가 입력되지 않았습니다!");
			 form.v_jumin.focus();
			 return false;
		 }
		 else if(form.v_name.value == "") {
			 alert("성명이 입력되지 않았습니다!");
			 return false;
		 }
		 else if(form.m_no.value == "") {
			 alert("후보가 선택되지 않았습니다!");
			 return false;
		 }
		 else if(form.v_time.value == "") {
			 alert("투표 시간이 입력되지 않았습니다!");
		 	 return false;
		 }
		 else if(form.v_area.value == "") {
			 alert("투표 장소가 입력되지 않았습니다!");
		 	 return false;
		 }
		 else if(form.v_confirm.value == "") {
			 alert("유권자 확인이 선택되지 않았습니다!");
			 return false;
		 }
		 document.vote_form.submit();
		 
	 }
</script>
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
	<h1 align="center">투표하기</h1>
</section>
<hr>
<form action="vote_completed.do" method="post" name="vote_form">
<table border="1" style="margin : 0 auto">
	<tr>
		<td>주민번호</td>
		<td><input type="text" size="30" name="v_jumin"></td>
	</tr>
	<tr>
		<td>성명</td>
		<td><input type="text" size="15" name="v_name"></td>
	</tr>
	<tr>
		<td>투표번호</td>
		<td>
			<select name="m_no">
				<option value="0"> 
				<option value="1"> [1] 김후보
				<option value="2"> [2] 이후보
				<option value="3"> [3] 박후보
				<option value="4"> [4] 조후보
				<option value="5"> [5] 최후보
			</select>
		</td>
	</tr>
	<tr>
		<td>투표 시간</td>
		<td><input type="text" size="15" name="v_time"></td>
	</tr>
	<tr>
		<td>투표 장소</td>
		<td><input type="text" size="30" name="v_area"></td>
	</tr>
	<tr>
		<td>유권자확인</td>
		<td>
			<input type="radio" name="v_confirm" value="Y">확인
			<input type="radio" name="v_confirm" value="N">미확인
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="button" value="투표하기" onclick="nullcheck()">
			<input type="reset" value="다시하기">
		</td>
	</tr>
	
</table>
</form>
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