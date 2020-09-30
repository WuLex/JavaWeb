package siso.wu.odd;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import siso.wu.model.Account;

public interface IAccountService {
	
	/**  
     * 构建用户记录  
     *   
     * @param account  
     * @return  
     */  
    void create(Account account);  
	
	/**  
     * 获得账户  
     *   
     * @param username  
     * @param password  
     * @return  
     */  
    @Transactional(readOnly = true)   
    Account read(String username, String password);   
  
    /**  
     * 获得账户  
     *   
     * @param id  
     * @return  
     */  
    @Transactional(readOnly = true)   
    Account read(int id);   
  
    /**  
     * 注册用户  
     *   
     * @param account  
     * @return  
     */  
    @Transactional(readOnly = false, rollbackFor = DataAccessException.class)   
    Account register(Account account);   
}
