package  siso.wu.hbm_component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(User.class)//
			.buildSessionFactory();

	// ����
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------
		User user = new User();
		user.setName("����");
		user.setUserAddress(new UserAddress("XX��ó԰", "888", "022-xxxxxx"));
		session.save(user); // ����
		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// ��ȡ
	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------


		User user = (User) session.get(User.class, 1);
		System.out.println(user.getName());
		System.out.println(user.getUserAddress().getAddress());

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
