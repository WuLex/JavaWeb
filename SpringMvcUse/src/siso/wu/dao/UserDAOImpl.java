package siso.wu.dao;

import org.junit.experimental.theories.ParameterSignature;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import siso.wu.model.UserInfo;

public class UserDAOImpl implements IUserDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void saveUser(UserInfo info) {
		 String sql="INSERT INTO [UserInfo] ([user_id] ,[name] ,[phone] ,[email]) VALUES(:user_id,:name ,:phone,:email)";
		 SqlParameterSource  parameterSource=new BeanPropertySqlParameterSource(info);
		 this.namedParameterJdbcTemplate.update(sql, parameterSource);
	}

	@Override
	public String RemoveUser() {
	 
		return null;
	}

}
