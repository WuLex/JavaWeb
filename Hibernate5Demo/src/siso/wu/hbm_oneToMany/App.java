package siso.wu.hbm_oneToMany;

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

	// ���棨����������
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// ��������
		Department department = new Department();
		department.setName("������");

		Employee employee1 = new Employee();
		employee1.setName("����");

		Employee employee2 = new Employee();
		employee2.setName("����");

		// ��������
		employee1.setDepartment(department);
	    employee2.setDepartment(department);
		//department.getEmployees().add(employee1);
		//department.getEmployees().add(employee2);

		// ����
		session.save(department); // ���沿��
		session.save(employee1);
		session.save(employee2);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// ��ȡ�����Ի�ȡ�������ĶԷ���
	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// ��ȡ���ţ�����ʾ������Ա����Ϣ
		Department department = (Department) session.get(Department.class, 3);
		System.out.println("�������ƣ�" + department.getName());
		System.out.println("������Ա����" + department.getEmployees());

		// // ��ȡԱ��������ʾ�����Ĳ�����Ϣ
		// Employee employee = (Employee) session.get(Employee.class, 1);
		// System.out.println("Ա��������" + employee.getName());
		// System.out.println("�����Ĳ��ţ�" + employee.getDepartment());

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// �Ƴ�������ϵ
	@Test
	public void testRemoveRelation() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// // ��Ա����������ԭ����
		// Employee employee = (Employee) session.get(Employee.class, 1);
		// employee.setDepartment(null);

		// ��Department�����κ�Employee����
		Department department = (Department) session.get(Department.class, 2);
		department.getEmployees().clear();

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// ɾ�������ԶԹ��������Ӱ�죩
	@Test
	public void testDelete() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// // ɾ��Ա�����Թ����Ĳ���û��Ӱ��
		// Employee employee = (Employee) session.get(Employee.class, 1);
		// session.delete(employee);

		// // ɾ�����ţ�����й�����Ա������᣺
		// 1��inverse="false"����Ҳ��Ĭ��ֵ����ʾ������ά��������ϵ�����������ʱ���Ȱ����й�����Ա�����Ƴ���ϵ����ɾ���Լ���
		// 2��inverse="true"����ʾ��������ά��������ϵ����������ͻ�ֱ��ɾ���Լ�����ʱ�����쳣��
		// 3�����cascade="delete"������inverse��Ϊʲô�����ܼ���ɾ����ص�Employee��Ϣ
		Department department = (Department) session.get(Department.class, 2);
		session.delete(department);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

}
