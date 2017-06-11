<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>Gallery Update</title>
		
		<!-- Bootstrap Core CSS -->
<link href="/WebTest1/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/WebTest1/resources/css/business-casual.css"
	rel="stylesheet">

<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

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
			}
		</script>
		
	
		
		
		
		
	</head>
	<body>
	
	<div class="brand">Make JAVA World</div>
	<div class="address-bar">WelCome to Java World | Professor Yong
		Kkon Shin | Made By SuYang Jung</div>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
	
	
		<h4>사진 수정</h4>
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
					<input type="text" class="form-control" placeholder="제목" value="${gallery.title}"name="title"/>
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
						<input id="attach" style="visibility:hidden;" type="file" name="attach" onchange="fileChange()"/><!-- multiple 안에 넣으면 여러 개 선택 가능 -->
					
					</div>
				</div>
			</div>
			
			<input type="submit" class="btn btn-info" value="수정"/>
		</form>
		
	
					</div>
			
			<div class="clearfix"></div>
			</div>
		</div>
	</div>
		<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<p>Copyright Su Yang Jung Contact: huntsu1234@gmail.com</p>
			</div>
		</div>
	</div>
	</footer>
	<!-- jQuery -->
	<script src="/WebTest1/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/WebTest1/resources/js/bootstrap.min.js"></script>
		
	</body>
</html>