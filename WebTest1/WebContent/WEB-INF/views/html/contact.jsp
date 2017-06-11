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

<title>Gallery</title>

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

	<
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
				<li><a href="blog.html">Board</a></li>
				<li><a href="contact">Contact</a></li>
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
						Contact <strong>Korea Software Industry Association</strong>
					</h2>
					<hr>
				</div>
				<div class="col-md-8">
					<!-- * Daum ���� - �����۰��� -->
					<!-- 1. ���� ��� -->
					<div id="daumRoughmapContainer1497201958266"
						class="root_daum_roughmap root_daum_roughmap_landing"></div>

					<!--
	2. ��ġ ��ũ��Ʈ
	* ���� �۰��� ���񽺸� 2�� �̻� ���� ���, ��ġ ��ũ��Ʈ�� �ϳ��� �����մϴ�.
-->
					<script charset="UTF-8" class="daum_roughmap_loader_script"
						src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>

					<!-- 3. ���� ��ũ��Ʈ -->
					<script charset="UTF-8">
						new daum.roughmap.Lander({
						"timestamp" : "1497201958266",
						"key" : "i53a",
						"mapWidth" : "600",
						"mapHeight" : "300"
					}).render();
				</script>
				</div>
				<div class="col-md-4">
					<p>
						Phone: <strong>+82 02.2188.6986</strong>
					</p>
					<p>
						Email: <strong><a href="sdm@sw.or.kr">sdm@sw.or.kr</a></strong>
					</p>
					<p>
						Address: <strong>���� ���ı� �ߴ�� 135, �������� IT ��óŸ�� ���� 12��</strong>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Contact <strong>form</strong>
					</h2>
					<hr>
					<p>���ǻ��� ����</p>
					<div class="row">
						<div class="form-group col-lg-4">
							<label>Name</label> <input type="text" class="form-control">
						</div>
						<div class="form-group col-lg-4">
							<label>Email Address</label> <input type="email"
								class="form-control">
						</div>
						<div class="form-group col-lg-4">
							<label>Phone Number</label> <input type="tel"
								class="form-control">
						</div>
						<div class="clearfix"></div>
						<div class="form-group col-lg-12">
							<label>Message</label>
							<textarea class="form-control" rows="6"></textarea>
						</div>
						<div class="form-group col-lg-12">
							<input type="hidden" name="save" value="contact">
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
					</form>
				</div>
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
