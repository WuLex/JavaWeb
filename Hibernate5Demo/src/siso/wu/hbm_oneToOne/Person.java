package siso.wu.hbm_oneToOne;

/**
 * ����
 * 
 * @author tyg
 * 
 */
public class Person {
	private Integer id;
	private String name;
	private IdCard idCard;

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

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

}