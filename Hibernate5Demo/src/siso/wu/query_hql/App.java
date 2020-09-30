package siso.wu.query_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(Department.class)//
			.addClass(Employee.class)//
			.buildSessionFactory();

	// �����������
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		for (int i = 1; i <= 10; i++) {
			Department department = new Department();
			department.setName("������_" + i);
			session.save(department);
		}

		for (int i = 1; i <= 20; i++) {
			// Employee employee1 = new Employee();
			// employee1.setName("Ա��_" + i);
			// session.save(employee1);
		}

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testHQL_1() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------
		String hql = null;

		// 1���򵥵Ĳ�ѯ��FROM �� AS��
		// hql = "FROM Employee";
		// hql = "FROM Employee AS e";
		hql = "FROM Employee e";

		// 2�����Ϲ��������ģ�����ʹ�ñ�������Where
		// hql = "FROM Employee e WHERE e.id=50";
		// hql = "FROM Employee e WHERE e.id>5 AND e.id<10";

		// 3���������������ģ�Order By
		// hql = "FROM Employee e ORDER BY e.id DESC, e.name ASC"; // ASC, DESC
		// hql = "FROM Employee e WHERE e.id>5 AND e.id<10 ORDER BY e.id DESC";

		// 4��ָ��select�Ӿ䣨������ʹ��select *��
		// ���ֻ��ѯһ�����ԣ����ѯ���Ľ�������о��������������
		// �����ѯ�ǵĶ�����ԣ����ѯ���Ľ����������Object���͵�����
		// ����ʹ��new�﷨��ָ���Ѳ�ѯ���Ĳ������Է�װ��������
		// hql = "SELECT e FROM Employee e";
		// hql = "SELECT e.id,e.name FROM Employee e";
		// hql =
		// "SELECT new cn.itcast.n_query_hql.Employee(e.id,e.name) FROM Employee e";

		// 5��ִ�в�ѯ����ý����list��uniqueResult����ҳ ��
		Query query = session.createQuery(hql);
		// >> a, ��ѯһ��Ψһ�Ľ�������û�н�����ͷ���null����������Ψһ�����ж�����ͻ����쳣
		// Object obj = query.uniqueResult();
		// System.out.println(obj);
		// >> b, ��ѯһ������
		// List list = query.list();
		// >> c, ��ҳ�Ĳ�ѯ, first, max
		// query.setFirstResult(10); // ������Ϊ10�ĵط���ʼ��ȡ
		// query.setMaxResults(10); // ����ȡ10�����
		// List list = query.list();

		// 6��������
		List list = session.createQuery(hql)//
				.setFirstResult(0)//
				.setMaxResults(10)//
				.list();

		// ִ�в�ѯ
		// Query query = session.createQuery(hql);
		// List list = query.list();

		// ��ʾ���
		for (Object obj : list) {
			if (obj.getClass().isArray()) {
				System.out.println(Arrays.toString((Object[]) obj));
			} else {
				System.out.println(obj);
			}
		}

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testHQL_2() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------
		String hql = null;

		// 1���ۼ�����
		// hql = "SELECT COUNT(*) FROM Employee e";
		// hql = "SELECT MAX(e.id) FROM Employee e";
		// hql = "SELECT COUNT(e.name) FROM Employee e";
		// hql = "SELECT COUNT(DISTINCT e.name) FROM Employee e";

		// 2������
		// hql = "SELECT e.name FROM Employee e WHERE e.id<13 GROUP BY e.name";
		// hql =
		// "SELECT e.name,COUNT(e.name) FROM Employee e WHERE e.id<13 GROUP BY e.name";
		// hql =
		// "SELECT e.name,COUNT(e.name) FROM Employee e WHERE e.id<16 GROUP BY e.name Having COUNT(e.name)>1";
		// hql =
		// "SELECT e.name,COUNT(e.name) FROM Employee e WHERE e.id<16 GROUP BY e.name Having COUNT(e.name)>1 ORDER BY COUNT(e.name) DESC";

		// 3�����Ӳ�ѯ
		// >> ��ѯָ�����ƵĲ��� �е�����Ա��������
		// hql =
		// "SELECT e.name FROM Employee e WHERE e.department.name='caiwu'";
		// hql =
		// "SELECT e.name FROM Employee e JOIN e.department d WHERE d.name='caiwu'";

		// HQL���������Ĳ�ѯ
		// hql = "SELECT e FROM Employee e WHERE e.department IS NULL";

		// 4����ѯʱʹ�ò���
		// >> ��ʽһ��ʹ��'?'ռλ
		// hql = "FROM Employee e WHERE e.id>? AND e.id<?";
		// Query query = session.createQuery(hql);
		// query.setParameter(0, 5); // ��1������λ����0
		// query.setParameter(1, 15); //
		// List list = query.list();
		// // >> ������
		// List list = session.createQuery(//
		// "FROM Employee e WHERE e.id>? AND e.id<?")//
		// .setParameter(0, 5)//
		// .setParameter(1, 15)//
		// .list();
		//
		// // >> ��ʽ����ʹ�ñ�����
		// list = session.createQuery(//
		// "FROM Employee e WHERE e.id>:idMin AND e.id<:idMax")//
		// .setParameter("idMin", 5)//
		// .setParameter("idMax", 10)//
		// .list();
		// // >> �������Ǽ��ϻ�����ʱ��ֻ��ʹ�ñ������ķ�ʽ����ͨ��setParameterList()���ò���
		// list = session.createQuery(//
		// "FROM Employee e WHERE e.id IN (:ids)")//
		// .setParameterList("ids", new Integer[] { 1, 2, 3, 5, 100 })//
		// .list();

		// 5��ʹ��������ѯ
		// Query query = session.getNamedQuery("QueryByIdMax");
		// query.setParameter("idMax", 10);
		// List list = query.list();

		// // ִ�в�ѯ
		// // Query query = session.createQuery(hql);
		// // List list = query.list();
		//
		// // ��ʾ���
		// for (Object obj : list) {
		// if (obj.getClass().isArray()) {
		// System.out.println(Arrays.toString((Object[]) obj));
		// } else {
		// System.out.println(obj);
		// }
		// }

		// 6��update��delete
		// *, ����֪ͨSession����
		Employee employee = (Employee) session.get(Employee.class, 13);
		System.out.println(employee.getName());

		// >> ����UPDATE
		int result = session.createQuery(//
				"UPDATE FROM Employee e SET e.name=? WHERE e.id>=?")//
				.setParameter(0, "������222333")//
				.setParameter(1, 13)//
				.executeUpdate();

		// *, ��update��delete����Ҫrefresh(obj)һ���Ի�ȡ���µ�״̬
		session.refresh(employee);
		System.out.println(employee.getName());

		// >> ����DELETE
		// int result = session.createQuery(//
		// "DELETE FROM Employee e WHERE e.id>?")//
		// .setParameter(0, 15)//
		// .executeUpdate();

		System.out.println("Ӱ�������Ϊ��" + result);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

}
