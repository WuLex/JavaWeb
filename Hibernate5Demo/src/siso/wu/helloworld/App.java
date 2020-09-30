package siso.wu.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory;

	static {
		// ��ȡ�����ļ�������Session��������
		Configuration cfg = new Configuration();
		// cfg.configure("hibernate.cfg.xml"); // ����ָ���������ļ�
		// cfg.configure(); // ��ȡĬ�ϵ������ļ���hibernate.cfg.xml��
		// cfg.addResource("cn/itcast/a_helloworld/User.hbm.xml");
		// cfg.addClass(User.class); //
		// sessionFactory = cfg.buildSessionFactory();

		sessionFactory = new Configuration()//
				.configure()//
				.addClass(User.class)// ����ָ�����Ӧ��ӳ���ļ���������Ϊǰ׺����׺Ϊ.hbm.xml��ͬһ�����µ��ļ���
				.buildSessionFactory();
	}

	// ����������ݿ�
	@Test
	public void testSave() throws Exception {
		// ׼������
		User user = new User();
		user.setName("����");

		// ���浽���ݿ���
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user); // ����
		tx.commit();
		session.close();
	}

	
	// �����ݿ��л�ȡһ������
	@Test
	public void testGet() throws Exception {
		/*Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, 1); // �����ݿ��л�ȡidΪ1��User����
		tx.commit();
		session.close();

		System.out.println(user); // ��ʾ��Ϣ
*/	}
}
