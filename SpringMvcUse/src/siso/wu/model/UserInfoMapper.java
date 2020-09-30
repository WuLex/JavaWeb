package siso.wu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserInfoMapper implements RowMapper{
 
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		 UserInfo item = new UserInfo();   
         item.setId(rs.getInt("id"));   
         item.setUser_id(rs.getInt("user_id"));   
         item.setName(rs.getString("name"));   
         item.setPhone(rs.getString("phone"));   
         item.setEmail(rs.getString("email"));   

         return item;   
	}

}
