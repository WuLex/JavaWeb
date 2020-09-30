package siso.wu.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import siso.wu.model.UserInfo;
import siso.wu.model.UserInfoMapper;

public class JDBCDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserInfo findById(int id) {   
	        String sql = "SELECT * FROM UserInfo WHERE id = ?";   
	        Object[] params = new Object[] { id };   
	        int[] types = new int[] { Types.INTEGER };   
	        List items = jdbcTemplate.query(sql, params, types, new UserInfoMapper());   
	        if (items.isEmpty()) {   
	            return null;   
	        }   
	        return (UserInfo)items.get(0);   
	    }   
	
	
	//查询一行一列
	public String queryfor(int id) {   
        String sql = "SELECT name FROM UserInfo WHERE id = ?";   
        String  name = jdbcTemplate.queryForObject(sql,String.class,id);   
        return name;
    }   
	
	 //查询一行多列
		public UserInfo queryUserInfo(int id) {   
	        String sql = "SELECT * FROM UserInfo WHERE id = ?";   
	        RowMapper<UserInfo> rowMapper=new BeanPropertyRowMapper<UserInfo>(UserInfo.class);
	        
	        UserInfo  userinfo= jdbcTemplate.queryForObject(sql,rowMapper,id);   
	        return userinfo;
	    } 
		
		public List<UserInfo> queryList() {   
	        String sql = "SELECT * FROM UserInfo ";   
	        RowMapper<UserInfo> rowMapper=new BeanPropertyRowMapper<UserInfo>(UserInfo.class);
	        
	        List<UserInfo>  userinfoList= jdbcTemplate.query(sql,rowMapper);   
	        return userinfoList;
	    }   
	
	public UserInfo insert(UserInfo item) {
		String sql = "INSERT INTO UserInfo(user_id,name,phone,email) VALUES(?,?,?,?)";
		Object[] params = new Object[] { item.getUser_id(), item.getName(),
				item.getPhone(), item.getEmail() };
		int[] types = new int[] { Types.INTEGER, Types.NVARCHAR, Types.VARCHAR,
				Types.VARCHAR };
		jdbcTemplate.update(sql, params, types);
		return item;
	}

	public UserInfo update(UserInfo item) {
		String sql = "UPDATE UserInfo SET name = ?, phone = ?, email = ? WHERE id = ?";
		Object[] params = new Object[] { item.getName(), item.getPhone(),
				item.getEmail(), item.getId() };
		int[] types = new int[] { Types.VARCHAR, Types.CHAR, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER };
		jdbcTemplate.update(sql, params, types);

		return item;
	}

}
