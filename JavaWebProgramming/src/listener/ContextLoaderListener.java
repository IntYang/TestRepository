package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
// �����Ϸ��� web.xml�� ����� �ؾ� ��.
public class ContextLoaderListener implements ServletContextListener {
// ContextLoaderListener : context�� deploy �� ���� �����ϰ� �ִٰ�, deploy �Ǵ� ���� initialize ����, undeploy �Ǵ� ���� destroyed
//undeploy : ��ġ�� �����ϴ� ��
	/*
	 * <listener>
  				<listener-class>listener.ContextLoaderListener</listener-class>
  		</listener>
	 * 
	 * */
	
	// �� ���ø����̼� ��ġ�ϴ� ���� �����Ű�� ������ ServletContextListener�� ������ Ŭ������ �����, web.xml�� listener�±׷� ����Ѵ�.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ContextLoaderListener contextInitialized() ����");
		String key1 = event.getServletContext().getInitParameter("key1"); // �� ���ø����̼� ��ü�� �� �ʱ�ȭ ���� ��ڴ� -> value1�� ��� ����
		System.out.println(key1);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ContextLoaderListener contextDestroyed()");
	}

	
	
}
