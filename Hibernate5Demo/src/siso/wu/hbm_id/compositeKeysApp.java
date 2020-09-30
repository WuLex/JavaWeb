package siso.wu.hbm_id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class compositeKeysApp {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(compositeKeys.class)//
			.buildSessionFactory();

	// ����
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------
		compositeKeys compositeKeysModel = new compositeKeys();
		compositeKeysModel.setFirstName("��");
		compositeKeysModel.setLastName("��");
		compositeKeysModel.setGender(true);
		session.save(compositeKeysModel); // ����
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

		compositeKeys compositeKeysMdl = new compositeKeys();
		compositeKeysMdl.setFirstName("��");
		compositeKeysMdl.setLastName("��");

		compositeKeys user = (compositeKeys) session.get(compositeKeys.class,
				compositeKeysMdl);
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getGender());

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
