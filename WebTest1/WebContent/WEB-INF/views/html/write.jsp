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
		<script type="text/javascript">
			function fileChange(){
				if($("#attach")[0].files.length!=0){
					var originalfilename = $("#attach")[0].files[0].name;
					$("#spanFileName").text(originalfilename); // 이름 바꾸는 기능
				}
			}
		
		
		</script>
	</head>
	<body>
		<h4>게시물 쓰기</h4>
		<hr/>
		
		<form method="post" style="padding: 0px 20px" enctype="multipart/form-data">
		<input type="hidden" name="gno" value="${gallery.gno}"/>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="제목" name="title" value="${gallery.gtitle}"/>
				</div>
			</div>
			
			
			
			
			

			<div class="form-group">
				<div class="input-group" style="height:47px;">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					<div class="form-control" style="height:47px;">
						<span id="spanFileName">${gallery.originalfilename}</span>
						<label for="attach" class="btn btn-default">변경</label>
						<input id="attach" style="visibility:hidden;" type="file" name="attach" onchange="fileChange()" multiple/><!-- multiple 안에 넣으면 여러 개 선택 가능 -->
					</div>
				</div>
			</div>
			
			<input type="submit" class="btn btn-info" value="수정"/>
		</form>
	</body>
</html>