package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
// 동작하려면 web.xml에 등록을 해야 함.
public class ContextLoaderListener implements ServletContextListener {
// ContextLoaderListener : context가 deploy 될 때를 감지하고 있다가, deploy 되는 순간 initialize 실행, undeploy 되는 순간 destroyed
//undeploy : 배치를 해제하는 것
	/*
	 * <listener>
  				<listener-class>listener.ContextLoaderListener</listener-class>
  		</listener>
	 * 
	 * */
	
	// 웹 어플리케이션 배치하는 순간 실행시키고 싶으면 ServletContextListener을 구현한 클래스를 만들고, web.xml에 listener태그로 등록한다.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ContextLoaderListener contextInitialized() 실행");
		String key1 = event.getServletContext().getInitParameter("key1"); // 웹 어플리케이션 객체를 얻어서 초기화 값을 얻겠다 -> value1을 얻어 저장
		System.out.println(key1);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ContextLoaderListener contextDestroyed()");
	}

	
	
}
