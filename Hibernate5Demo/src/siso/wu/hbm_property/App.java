package siso.wu.hbm_property;

import java.io.FileInputStream;
import java.util.Date;

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

		// ��һ��ͼƬ�ļ�
		FileInputStream in = new FileInputStream("E:/ͼƬ/apple1.jpg");
		byte[] photo = new byte[in.available()];
		in.read(photo);
		in.close();

		// ׼������
		User user = new User();
		user.setName("����");
		user.setGender(true);
		user.setBirthday(new Date());
		user.setDesc("һ��ε�˵�����˴�ʡ��1000��...");
		user.setPhoto(photo);

		// ����
		session.save(user);

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
		System.out.println(user.getGender());
		System.out.println(user.getBirthday());
		System.out.println(user.getDesc());
		System.out.println(user.getPhoto());

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
