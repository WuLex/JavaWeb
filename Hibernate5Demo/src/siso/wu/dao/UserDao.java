package siso.wu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import siso.wu.helloworld.User;

public class UserDao {
	
	private static SessionFactory sessionFactory;

	static {
		// ��ȡ�����ļ�������Session��������
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user); // ����
			tx.commit();
		} catch (RuntimeException e) {
			// tx.rollback();
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user); // ����
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	
	/**
	 * ɾ��ָ��id���û�
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// -------------------------------------
			Object user = session.get(User.class, id); // �ȴ����ݿ��ȡ����
			session.delete(user); // ɾ������ʵ�����
			// -------------------------------------
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * ��ȡָ��id�Ķ���
	 * 
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, id); // ��ȡ
			tx.commit();
			return user;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<User> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<User> list = session.createQuery("FROM User").list(); // ʹ��HQL��ѯ
			tx.commit();
			return list;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * ��ҳ�Ĳ�ѯ
	 * 
	 * @param firstResult
	 *            ��ʼ��ȡ�ļ�¼������
	 * @param maxResults
	 *            ����ȡ����������
	 * @return �ܼ�¼�� + һ������
	 */
	public QueryResult<User> findAll(int firstResult, int maxResults) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// -------------------------------------
			// 1����ѯ�ܼ�¼��
			Long count = (Long) session.createQuery("SELECT COUNT(*) FROM User").uniqueResult(); // ִ�в�ѯ

			// 2����ѯһ������
			Query query = session.createQuery("FROM User");
			
			
			/*�ɴ˿��Կ���Hibernate�� sql server ��ҳȫ�ǲ�ȡ top ��ʽ���������¼��10W�����ϵĻ������漸ҳЧ�ʻ�ǳ��͡�
			 * ��getLimitString(String querySelect, int offset, int limit)�������Կ��� sql server ��֧�� offset ����(��Ϊ0)����
			Ȼ����sql server2005����֧��ROW_NUMBER() ����,���øú��������߷�ҳЧ�ʡ�
			�����е�Hibernate api��֧�ָú��������ǿ�����дpublic String getLimitString(String querySelect, int offset, int limit)
			������ʵ�� ROW_NUMBER����ҳ,��д�ķ������£�
			public String getLimitString(String querySelect, int offset, int limit )
		     ......
		     .......
		���Խ�����£�
            Query q = session.createQuery("from Cat as c order by c.id asc"); //ע��Ҫ�� order by�������õ� ROW_NUMBER��ҳ
            q.setFirstResult(10000);
            q.setMaxResults(20);
            List l = q.list();
                              ���ɵ�sql ���Ϊ
            select * from (select   ....,ROW_NUMBER() OVER(order by cat0_.id asc) as _page_row_num_hb from cat as cat0_) temp 
            where _page_row_num_hb BETWEEN  10001 and 10020
            */
			
			
			
			//query.setFirstResult(firstResult); //��sql server�г���
			//query.setMaxResults(maxResults);
			List<User> list = query.list(); // ִ�в�ѯ

			// -------------------------------------
			tx.commit();
			return new QueryResult<User>(list, count);
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	} 

}
