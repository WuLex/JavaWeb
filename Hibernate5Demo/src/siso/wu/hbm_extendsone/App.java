package siso.wu.hbm_extendsone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.addClass(Article.class)//
			.buildSessionFactory();

	// ����
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ---------------------------------------

		// ��������
		Article article = new Article();
		article.setTitle("����һ��Article");

		Topic topic = new Topic();
		topic.setTitle("����һ������");
		topic.setType(1); // ����1��ʾ������

		Reply reply = new Reply();
		reply.setTitle("����һ���ظ�");
		reply.setFloor(1); // 1¥

		// ����
		session.save(article);
		session.save(topic);
		session.save(reply);

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

		// ���ݾ�������ͻ�ȡ
		Article article = (Article) session.get(Article.class, 1);
		Topic topic = (Topic) session.get(Topic.class, 2);
		Reply reply = (Reply)session.get(Reply.class, 3);
		System.out.println(article);
		System.out.println(topic);
		System.out.println(reply);
		System.out.println("---");
		
		// ���ݸ������ͻ�ȡ��������
		Article article1 = (Article) session.get(Article.class, 2);
		Article article2 = (Article)session.get(Article.class, 3);
		System.out.println(article1);
		System.out.println(article2);
		
		
		// ---------------------------------------
		session.getTransaction().commit();
		session.close();
	}

}
