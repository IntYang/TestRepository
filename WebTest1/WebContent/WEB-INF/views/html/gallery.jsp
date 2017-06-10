<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>About - Business Casual - Start Bootstrap Theme</title>

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
	
</head>
<body>

	<div class="brand">Make JAVA World</div>
	<div class="address-bar">WelCome to Java World | Professor Yong
		Kkon Shin | Made By SuYang Jung</div>
	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
			<a class="navbar-brand" href="index.html">Business Casual</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/WebTest1">Home</a></li>
				<li><a href="gallery">Gallery</a></li>
				<li><a href="blog.html">Blog</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<div class="container">

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						About <strong>USING GALLERY</strong>
					</h2>
					<hr>
				</div>
				<div class="col-md-6">
					<img class="img-responsive img-border-left"
						src="/WebTest1/resources/img/slide-2.jpg" alt="">
				</div>
				<div class="col-md-6">
					<p>This is a great place to introduce your company or project
						and describe what you do.</p>
					<p>Lid est laborum dolo rumes fugats untras. Etharums ser
						quidem rerum facilis dolores nemis omnis fugats vitaes nemo minima
						rerums unsers sadips amets.</p>
					<p>Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo.</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Our <strong>IOT Class</strong>
					</h2>
					<hr>
					
			<a href="galleryWrite">
			<span style="float:right">	<input type="button" class="btn btn-success" value="작성"/> </span>
			</a>
					
				</div>


				<div class="col-lg-12">
				<ul style="line-height:0;">
					<li><c:forEach var="g" items="${list}">
					
						<div class="col-sm-4 text-center" style="border: 1px solid black; width: 33%; margin: 10px 10px 10px 10px;">
							<a href="galleryDetail?gno=${g.gno}"> <img
								class="img-responsive" src="file/upload?gno=${g.gno}"
								style="vertical-align: center; width: auto; height: 250px;"
								alt=""></a> 
						</div>
						
					</c:forEach></li>
				</ul>
				</div>


				<div class="row text-center">
				<ul class="pagination">
					<li><a href="gallery?pageNo=1">처음</a></li>

					<c:if test="${groupNo>1}">
						<li><a href="gallery?pageNo=${startPageNo-1}">이전</a></li>
					</c:if>
					
					
					<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				&nbsp; <!-- 공백임, "문자 참조" -->
					<li>	<a href="gallery?pageNo=${i}"
							<c:if test="${pageNo==i}"> style="font-weight:bold; color:red; text-align: center;" </c:if>>
							${i} </a>			</li>							
				&nbsp;
			</c:forEach>
					

					<c:if test="${groupNo<totalGroupNo}">
						<li><a href="gallery?pageNo=${endPageNo+1}">다음</a></li>
					</c:if>

					<li><a href="gallery?pageNo=${totalPageNo}">맨끝</a></li>
					</ul>
				</div>






				<div class="clearfix"></div>
			</div>
		</div>

	</div>
	<!-- /.container -->

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