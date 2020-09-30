package siso.wu.hbm2ddls;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import siso.wu.helloworld.User;

public class App {
	@Test
	public void testHbm2ddl() throws Exception {
		Configuration cfg = new Configuration()//
				.configure()//
				.addClass(User.class);
		// �Զ������ɾ����Ĺ�����SchemaExport
		SchemaExport schemaExport = new SchemaExport(cfg);
		// ��1������script�����ã� print the DDL to the console
		// ��2������export�����ã� export the script to the database
		schemaExport.create(true, true); // �Զ�����
	}
}
