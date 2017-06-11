<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>Gallery Detail</title>

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



<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
</head>


<body>

	<div class="brand">Make JAVA World</div>
	<div class="address-bar">WelCome to Java World | Professor Yong
		Kkon Shin | Made By SuYang Jung</div>


	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">

					<h4>사진 상세보기</h4>
					<hr />

					<form method="post" style="padding: 0px 20px"
						enctype="multipart/form-data">
						
						
						<div class="col-sm-4" style="float:left; width: 33%; margin: 10px 10px 10px 10px;">
							 <img
								class="img-responsive" src="file/upload?gno=${gallery.gno}"
								style="vertical-align: center; width: auto; height: 250px;"
								alt="">
						</div>

						<div class="form-group">
						<br/>
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-user"></span>
								</span> <input type="text" class="form-control" placeholder=""
									name="gno" value="${gallery.gno}" disabled />
							</div>
						</div>


						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-tag"></span>
								</span> <input type="text" class="form-control" placeholder="제목"
									value="${gallery.title}" name="title" disabled />
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-camera"></span>
								</span> <a class="form-control" href="#">${gallery.originalfilename}</a>

							</div>

							
						</div>
				



			<!--<a href="exam06" class="btn btn-success">목록</a>   -->

			<a href="gallery"> <input type="button" class="btn btn-success"
				value="목록" />
			</a> <a href="galleryUpdate?gno=${gallery.gno}"> <input type="button"
				class="btn btn-warning" value="수정" />
			</a> <a href="galleryDelete?gno=${gallery.gno}"> <input type="button"
				class="btn btn-danger" value="삭제" />
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