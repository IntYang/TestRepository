<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JSP Page</title>
		<script>
			//전역 변수
			var v1="A";
			
			function fun1(){
				// 로컬변수
				var v2 = "B";
				if(true){
					var v3 = "C";
					v4 = "D"; // 선언 안하고 사용해도 에러 안남, 이건 전역변수
				}
				console.log(v1);
				console.log(v2);
				console.log(v3); // 자바 스크립트는 블록 단위의 변수가 아니라 함수 단위의 변수만 존재
				console.log(v4); 
			}
			
			
			
			console.log(v1);
			//console.log(v2); // 불가능
			//console.log(v3); // 불가능
			fun1();
			console.log(v4); // 불가능
		</script>
	</head>
	<body>
	</body>
</html>
