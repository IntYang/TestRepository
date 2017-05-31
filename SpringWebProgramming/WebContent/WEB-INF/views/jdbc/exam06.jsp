<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<body>
		<h4>게시물 목록</h4>
		<hr/>
		
		<table class="table table-bordered">
			<tr class="success">
				<td>아이디</td>
				<td>이름</td>
				<td>전화번호</td>
				<td>날짜</td>
				<td>나이</td>
			</tr>
			<c:forEach var="m" items="${mlist}">
				<tr>
					<td>${m.mid}</td>
					<td>${m.mname}</td>
					<td>${m.mtel}</td>
					<td>${m.mdate}</td>
					<td>${m.mage}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div style="margin-top: 20px;width:700px;text-align:center;">
			<a href="exam06?pageNo=1">[처음]</a>
		
			<c:if test="${groupNo>1}">
				<a href="exam06?pageNo=${startPageNo-1}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				&nbsp; <!-- 공백임, "문자 참조" -->
				<a href="exam06?pageNo=${i}"
					<c:if test="${pageNo==i}"> style="font-weight:bold; color:red;" </c:if>>
					${i}
				</a>										
				&nbsp;
			</c:forEach>
			
			
			<c:if test="${groupNo<totalGroupNo}">
				<a href="exam06?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>
			
			<a href="exam06?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
	</body>
</html>