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

	// 保存
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		Set<String> addressSet = new HashSet<String>();
		addressSet.add("棠东东路...");
		addressSet.add("御富科贸园...");

		User user = new User();
		user.setName("张三");
		user.setAddressSet(addressSet);
		// List
		user.getAddressList().add("1.棠东东路");
		user.getAddressList().add("2.御富科贸园");

		/*// Map
		user.getAddressMap().put("公司", "御富科贸园");
		user.getAddressMap().put("家", "棠东东路");

		// 数组
		user.setAddressArray(new String[] { "御富科贸园", "棠东东路" });

		// Bag（没有顺序，可以重复）
		user.getAddressBag().add("棠东东路");
		user.getAddressBag().add("御富科贸园");
		user.getAddressBag().add("御富科贸园");*/

		session.save(user); // 保存
		System.out.println("新对象的ID=" + user.getId());
		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// 获取
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
