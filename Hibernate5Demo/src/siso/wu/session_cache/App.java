package siso.wu.session_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(User.class)// ����ָ�����Ӧ��ӳ���ļ���������Ϊǰ׺����׺Ϊ.hbm.xml��ͬһ�����µ��ļ���
			.buildSessionFactory();

	@Test
	public void testRefresh() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// ��ȡ����
		User user = (User) session.get(User.class, 3);
		System.out.println(user.getName());

		// ˢ�¶����״̬�������ݿ����ٻ�ȡһ������״̬��
		session.refresh(user);
		System.out.println(user.getName());

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// �����������ݲ���û���ڴ�������쳣
	@Test
	public void testBatchSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setName("test-" + i);
			session.save(user); // ����

			// Ӧ��ʱ����ջ��棬���ͷ��ڴ�
			if (i % 10 == 0) {
				System.out.println("ˢ��");
				session.flush();
				session.clear();
			}
		}

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
