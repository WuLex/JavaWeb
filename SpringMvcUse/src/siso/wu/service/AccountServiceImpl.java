package siso.wu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import siso.wu.dao.AccountDao;
import siso.wu.model.Account;
import siso.wu.odd.IAccountService;

public class AccountServiceImpl implements IAccountService {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    @Autowired  
    private AccountDao accountDao;  
	
	@Override
	public Account read(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account register(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override  
    public void create(Account account) {   
        String sql = "INSERT INTO account(username, password, birthday, email) VALUES(?,?,?,?)";   
  
        jdbcTemplate.update(sql, new Object[] { account.getUsername(),   
                account.getPassword(), account.getBirthday(),   
                account.getEmail() });   
    }   

}
