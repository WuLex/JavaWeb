package siso.wu.hbm_property;

import java.util.Date;

public class User {
	private Integer id;
	private String name; // ����
	private boolean gender; // true��ʾ�У�false��ʾŮ
	private Date birthday; // ����
	private String desc; // һ���˵�������Ϊ5000��
	private byte[] photo; // ��Ƭ

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
