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
		// 读取配置文件并生成Session工厂对象
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user); // 保存
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
	 * 更新用户
	 * 
	 * @param user
	 */
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user); // 更新
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	
	/**
	 * 删除指定id的用户
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// -------------------------------------
			Object user = session.get(User.class, id); // 先从数据库获取对象
			session.delete(user); // 删除的是实体对象
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
	 * 获取指定id的对象
	 * 
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, id); // 获取
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
	 * 查询所有
	 * 
	 * @return
	 */
	public List<User> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<User> list = session.createQuery("FROM User").list(); // 使用HQL查询
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
	 * 分页的查询
	 * 
	 * @param firstResult
	 *            开始获取的记录的索引
	 * @param maxResults
	 *            最多获取多少条数据
	 * @return 总记录数 + 一段数据
	 */
	public QueryResult<User> findAll(int firstResult, int maxResults) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// -------------------------------------
			// 1，查询总记录数
			Long count = (Long) session.createQuery("SELECT COUNT(*) FROM User").uniqueResult(); // 执行查询

			// 2，查询一段数据
			Query query = session.createQuery("FROM User");
			
			
			/*由此可以看出Hibernate对 sql server 分页全是采取 top 方式来处理。如记录有10W条以上的话到后面几页效率会非常低。
			 * 从getLimitString(String querySelect, int offset, int limit)方法可以看出 sql server 不支持 offset 参数(均为0)！！
			然而在sql server2005过后支持ROW_NUMBER() 函数,可用该函数大大提高分页效率。
			但现有的Hibernate api不支持该函数。我们可以重写public String getLimitString(String querySelect, int offset, int limit)
			方法来实现 ROW_NUMBER　分页,重写的方法如下：
			public String getLimitString(String querySelect, int offset, int limit )
		     ......
		     .......
		测试结果如下：
            Query q = session.createQuery("from Cat as c order by c.id asc"); //注意要加 order by　才能用到 ROW_NUMBER分页
            q.setFirstResult(10000);
            q.setMaxResults(20);
            List l = q.list();
                              生成的sql 语句为
            select * from (select   ....,ROW_NUMBER() OVER(order by cat0_.id asc) as _page_row_num_hb from cat as cat0_) temp 
            where _page_row_num_hb BETWEEN  10001 and 10020
            */
			
			
			
			//query.setFirstResult(firstResult); //在sql server中出错
			//query.setMaxResults(maxResults);
			List<User> list = query.list(); // 执行查询

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
