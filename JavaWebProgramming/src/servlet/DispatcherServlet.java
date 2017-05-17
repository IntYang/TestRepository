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
		System.out.println("DispatcherServlet�� init()����");
		String name1 = config.getInitParameter("name1"); // init parma���� �Ѱ��� name ���� ���� value�� ���´�
		String name2 =  config.getInitParameter("name2");
		
		System.out.println(name1);
		System.out.println(name2);
	} // init �޼ҵ�� Ŭ���̾�Ʈ�� ���ʷ� ��û���� �� 1���� ����ǰ�, �������ʹ� service() �޼ҵ常 ����ȴ�
	
	// servlet ��ü�� �ϳ��� �������, ��������� ����?
	// �� ���ø����̼��� ��Ĺ�� ���������� �� or Ŭ���̾�Ʈ�� ���ʷ� ��û�� ��
	// ����Ʈ�� Ŭ���̾�Ʈ�� ���ʷ� ��û�� ����
    // �⺻ �����ڷ� Ȯ���ؔh - ��Ĺ�� �⺻ �����ڷ� �����ϱ� ������	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() ����");
	
	}
}
