package siso.wu.hbm_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(Person.class)//
			.addClass(IdCard.class)//
			.buildSessionFactory();

	// ���棨����������
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// ��������
		Person person = new Person();
		person.setName("����");

		IdCard idCard = new IdCard();
		idCard.setNumber("01111222");

		// ��������
		// ʹ�û��������һ��һʱ��Person�����������������ά��������ϵ
		// ʹ�û��������һ��һʱ��IdCard���������������ά��������ϵ
		// ʹ�û���������һ��һʱ��Ҳ��ֻ������������Ա��������ϵ
		// person.setIdCard(idCard);
		idCard.setPerson(person);

		// ����
		session.save(idCard);
		session.save(person);

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
		Person person = (Person) session.get(Person.class, 1);
		System.out.println("������" + person.getName());
		System.out.println("���֤��Ϣ��" + person.getIdCard());

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// �Ƴ�������ϵ
	// ʹ�û���������һ��һʱ��˫�����������Ƴ�������ϵ
	@Test
	public void testRemoveRelation() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// // ��ȡһ��Person�����Ƴ���IdCard�Ĺ���
		// ʹ�û��������һ��һʱ��Person�����������������ά��������ϵ
		// Person person = (Person) session.get(Person.class, 1);
		// person.setIdCard(null);

		// ��ȡһ��IdCard�����Ƴ����Person����
		// ʹ�û��������һ��һʱ��IdCard���������������ά��������ϵ
		IdCard idCard = (IdCard) session.get(IdCard.class, 1);
		idCard.setPerson(null);

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

		// ��ΪPerson��������ԣ�������ά��������ϵ������ɾ��Personʱ������й�����IdCard���ͻ����쳣
		Person person = (Person) session.get(Person.class, 3);
		session.delete(person);

		// // ɾ��IdCard
		// IdCard idCard = (IdCard) session.get(IdCard.class, 2);
		// session.delete(idCard);

		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

}
