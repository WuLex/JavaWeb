package siso.wu.hbm_manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(Teacher.class)//
			.addClass(Student.class)//
			.buildSessionFactory();

	// ���棨����������
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// ��������
		Teacher teacher1 = new Teacher();
		teacher1.setName("����ʦ");

		Teacher teacher2 = new Teacher();
		teacher2.setName("����ʦ");

		Student student1 = new Student();
		student1.setName("����");

		Student student2 = new Student();
		student2.setName("����");

		// ��������
		teacher1.getStudents().add(student1);
		teacher1.getStudents().add(student2);
		teacher2.getStudents().add(student1);
		teacher2.getStudents().add(student2);

		student1.getTeachers().add(teacher1);
		student1.getTeachers().add(teacher2);
		student2.getTeachers().add(teacher1);
		student2.getTeachers().add(teacher2);

		// ����
		session.save(teacher1);
		session.save(teacher2);
		session.save(student1);
		session.save(student2);

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

		// ��ȡһ��Student������ʾ��ص�Teacher��Ϣ
		Student student = (Student) session.get(Student.class, 3);
		System.out.println("ѧ����������" + student.getName());
		System.out.println("��ѧ������ʦ��" + student.getTeachers());

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

		// ��ȡһ��Student�����Ƴ���������ʦ�Ĺ���
		Student student = (Student) session.get(Student.class, 5);
		student.getTeachers().clear();

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

		// ɾ��һ��Student������й�������ʦ����
		// ���inverse="false"����ʾ����ά��������ϵ����ʱ����ɾ����ϵ����ɾ���Լ���
		// ���inverse="true"����ʾ������ά��������ϵ����ʱ��ֱ��ɾ���Լ��������쳣��
		Student student = (Student) session.get(Student.class, 5);
		session.delete(student);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

}
