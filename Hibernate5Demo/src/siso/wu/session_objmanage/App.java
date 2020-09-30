package siso.wu.session_objmanage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(User.class)// 加载指定类对应的映射文件（以类名为前缀，后缀为.hbm.xml的同一个包下的文件）
			.buildSessionFactory();

	// save()
	// 把临时状态转为持久化状态
	// 生成并执行一条insert语句
	// 只有在主键由数据库生成时，save(obj)时的sql语句才会马上执行，以获取主键值
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		User user = new User(); // 临时状态
		user.setName("张三");

		// 测试OID
		System.out.println(user.getId()); // null
		session.save(user); // 持久化状态
		System.out.println(user.getId()); // 有值

		// // 测试持久化状态对象的修改
		// // 修改对象后，最终会同步到数据库中
		// user.setName("李四");
		// System.out.println("---");

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// update()
	// 把游离状态转为持久化状态
	// 会生成Update语句
	@Test
	public void testUpdate() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		User user = (User) session.get(User.class, 1);
		// user.setName("aa");

		// 从Session中清出指定对象，这个对象就是游离状态了
		session.evict(user);
		user.setName("bb");

		// 再次获取这个对象，因为之前的已从Session中清除，所以这次没有使用缓存，而是去数据库中取。
		User user2 = (User) session.get(User.class, 1);
		System.out.println(user == user2);

		// 把游离状态对象放到Session管理中
		session.update(user);
		session.flush(); // 刷出，表示立即执行SQL语句
		System.out.println("---");

		// ---------------------------------------
		session.getTransaction().commit(); // 在提交时，会自动的先执行flush()
		session.close();
	}

	// 更新时要求数据库中一定要有对应id的记录，否则抛异常
	@Test
	public void testUpdate2() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// 模拟一个游离状态的对象
		User user = new User();
		user.setId(100);
		user.setName("abcd");

		session.update(user);

		// ---------------------------------------
		session.getTransaction().commit(); // 在提交时，会自动的先执行flush()
		session.close();
	}

	// saveOrUpdate()
	// 把临时或游离状态转为持久化状态
	// 如果是临时状态，就生成insert语句
	// 如果是游离状态，就生成update语句
	// 检测对象是什么状态，默认是看主键值，为null（对象时）或0（原始类型时）时表示临时状态，否则就是游离状态。
	@Test
	public void testSaveOrUpdate() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		User user = new User();
		user.setId(1);
		user.setName("王五2");

		session.saveOrUpdate(user);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// delete()
	// 把持久化或游离状态转为删除状态
	// 会生成一条delete语句
	// 要求数据库中一定要有对应的记录，否则抛异常，删除不成功
	@Test
	public void testDelete() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// 加载出一个对象，就是持久化状态
		// User user = (User) session.get(User.class, 1);

		// 模拟一个游离状态的对象
		User user = new User();
		user.setId(200);

		session.delete(user);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// get()
	// 查询出来的就是持久化状态，因为在Session中，再
	// 马上执行查询
	// 如果没有对应记录，就返回null
	// 本方法会使用缓存，缓存中没有，才查询数据库
	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		User user = (User) session.get(User.class, 3);
		User user2 = (User) session.get(User.class, 3);
		User user3 = (User) session.get(User.class, 3);
		System.out.println("---");
		System.out.println(user);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
