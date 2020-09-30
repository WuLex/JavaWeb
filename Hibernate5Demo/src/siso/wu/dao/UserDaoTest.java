package siso.wu.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import siso.wu.helloworld.User;

public class UserDaoTest {

	private UserDao userDao = new UserDao();

	@Test
	public void testSave() {
		// 准备对象
		User user = new User();
		user.setName("张小龙");
		// 保存到数据库中
		userDao.save(user);
	}

	@Test
	public void testSave_25() {
		for (int i = 26; i <= 145; i++) {
			User user = new User();
			user.setName("张-" + i);
			userDao.save(user);
		}
	}
	
	@Test
	public void testUpdate() {
		// 修改已有的对象
		User user = userDao.getById(1);
		user.setName("李四");
		// 更新到数据库中
		userDao.update(user);
	}

	@Test
	public void testDelete() {
		userDao.delete(10);
	}

	@Test
	public void testGetById() {
		User user = userDao.getById(1);
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		// 查询
		List<User> list = userDao.findAll();

		// 显示
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindAllIntInt() {
		// 分页的查询
		// QueryResult<User> qr = userDao.findAll(0, 10); // 第1页，每页10条
		// QueryResult<User> qr = userDao.findAll(10, 10); // 第2页，每页10条
		QueryResult<User> qr = userDao.findAll(1, 10); // 第3页，每页10条

		// 显示
		System.out.println("总记录的数量：" + qr.getCount());
		for (User user : qr.getList()) {
			System.out.println(user);
		}
	}

}
