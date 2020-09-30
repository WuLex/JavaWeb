package siso.wu.dao;


import java.util.List;

public class QueryResult<T> {
	private List<T> list; // һ������
	private Long count; // �ܼ�¼��

	public QueryResult(List<T> list, Long count) {
		this.list = list;
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
