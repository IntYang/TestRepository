package com.mycompany.myapp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({
	// 스프링 설정파일 명시
	"file:WebContent/WEB-INF/spring/applicationContext.xml", 
	"file:WebContent/WEB-INF/spring/dispatcher-servlet.xml"
})

// @WebAppConfiguration()은 웹 컨텐트가 src/main/webapp 존재하여야 함
@WebAppConfiguration("WebContent")
public class ApplicationContextLoader {

	
}
