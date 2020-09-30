package crm.domain;

public class SysUserGroup {

	private Integer id;
	private String remark; 
	private String name;
	private String principal;
	 
	private String incumbent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getIncumbent() {
		return incumbent;
	}

	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}
	
	
}
