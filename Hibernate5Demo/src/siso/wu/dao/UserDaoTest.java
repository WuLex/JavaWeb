package siso.wu.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import siso.wu.helloworld.User;

public class UserDaoTest {

	private UserDao userDao = new UserDao();

	@Test
	public void testSave() {
		// ׼������
		User user = new User();
		user.setName("��С��");
		// ���浽���ݿ���
		userDao.save(user);
	}

	@Test
	public void testSave_25() {
		for (int i = 26; i <= 145; i++) {
			User user = new User();
			user.setName("��-" + i);
			userDao.save(user);
		}
	}
	
	@Test
	public void testUpdate() {
		// �޸����еĶ���
		User user = userDao.getById(1);
		user.setName("����");
		// ���µ����ݿ���
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
		// ��ѯ
		List<User> list = userDao.findAll();

		// ��ʾ
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindAllIntInt() {
		// ��ҳ�Ĳ�ѯ
		// QueryResult<User> qr = userDao.findAll(0, 10); // ��1ҳ��ÿҳ10��
		// QueryResult<User> qr = userDao.findAll(10, 10); // ��2ҳ��ÿҳ10��
		QueryResult<User> qr = userDao.findAll(1, 10); // ��3ҳ��ÿҳ10��

		// ��ʾ
		System.out.println("�ܼ�¼��������" + qr.getCount());
		for (User user : qr.getList()) {
			System.out.println(user);
		}
	}

}
