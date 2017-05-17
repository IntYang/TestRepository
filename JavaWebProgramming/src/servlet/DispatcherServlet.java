package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("DispatcherServlet의 init()실행");
		String name1 = config.getInitParameter("name1"); // init parma에서 넘겨준 name 값에 따른 value가 나온다
		String name2 =  config.getInitParameter("name2");
		
		System.out.println(name1);
		System.out.println(name2);
	} // init 메소드는 클라이언트가 최초로 요청했을 때 1번만 실행되고, 다음부터는 service() 메소드만 실행된다
	
	// servlet 객체는 하나만 만들어짐, 만들어지는 시점?
	// 웹 어플리케이션이 톰캣이 디폴로이할 때 or 클라이언트가 최초로 요청할 때
	// 디폴트는 클라이언트가 최초로 요청할 때임
    // 기본 생성자로 확인해봦 - 톰캣이 기본 생성자로 생성하기 때문에	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
	
	}
}
