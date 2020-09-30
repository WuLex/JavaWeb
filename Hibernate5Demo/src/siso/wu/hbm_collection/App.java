package siso.wu.hbm_collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

		Set<String> addressSet = new HashSet<String>();
		addressSet.add("�Ķ���·...");
		addressSet.add("������ó԰...");

		User user = new User();
		user.setName("����");
		user.setAddressSet(addressSet);
		// List
		user.getAddressList().add("1.�Ķ���·");
		user.getAddressList().add("2.������ó԰");

		/*// Map
		user.getAddressMap().put("��˾", "������ó԰");
		user.getAddressMap().put("��", "�Ķ���·");

		// ����
		user.setAddressArray(new String[] { "������ó԰", "�Ķ���·" });

		// Bag��û��˳�򣬿����ظ���
		user.getAddressBag().add("�Ķ���·");
		user.getAddressBag().add("������ó԰");
		user.getAddressBag().add("������ó԰");*/

		session.save(user); // ����
		System.out.println("�¶����ID=" + user.getId());
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
		System.out.println(user.getAddressSet());
		System.out.println(user.getAddressList());
		System.out.println(user.getAddressMap());
		System.out.println(Arrays.toString(user.getAddressArray()));
		System.out.println(user.getAddressBag());
		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
