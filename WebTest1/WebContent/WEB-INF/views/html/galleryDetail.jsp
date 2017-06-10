<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>Gallery Detail</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<body>
	
	
	</head>
	<body>
		<h4>사진 상세보기</h4>
		<hr/>
		
		<form method="post" style="padding: 0px 20px" enctype="multipart/form-data">
		
		<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="" name="gno" value="${gallery.gno}" disabled/>
				</div>
			</div>
		
		
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-tag"></span>
					</span>
					<input type="text" class="form-control" placeholder="제목" value="${gallery.title}"name="title" disabled/>
				</div>
			</div>
		
		<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					
					<a class="form-control" href="#">${gallery.originalfilename}</a>
				</div>
			</div>
			
	
			
			<!--<a href="exam06" class="btn btn-success">목록</a>   -->
			
			<a href="gallery">
				<input type="button" class="btn btn-success" value="목록"/>
			</a>
			<a href="galleryUpdate?gno=${gallery.gno}">
				<input type="button" class="btn btn-warning" value="수정"/>
			</a>
			<a href="galleryDelete?gno=${gallery.gno}">
			<input type="button" class="btn btn-danger" value="삭제"/>
			</a>
			<!-- 
			<button>버튼</button>                // submit 기능
			<input type="button" value="버튼"/> 
			<input type="submit" value="버튼"/>  // submit 기능
			<input type="cancel" value="버튼"/>
			<input type="image" src="버튼.png"/> // submit 기능
			<img src="버튼.png"/>
			 -->
		</form>	
	</body>
</html>