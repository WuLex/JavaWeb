package siso.wu.odd;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import siso.wu.model.Account;

public interface IAccountService {
	
	/**  
     * �����û���¼  
     *   
     * @param account  
     * @return  
     */  
    void create(Account account);  
	
	/**  
     * ����˻�  
     *   
     * @param username  
     * @param password  
     * @return  
     */  
    @Transactional(readOnly = true)   
    Account read(String username, String password);   
  
    /**  
     * ����˻�  
     *   
     * @param id  
     * @return  
     */  
    @Transactional(readOnly = true)   
    Account read(int id);   
  
    /**  
     * ע���û�  
     *   
     * @param account  
     * @return  
     */  
    @Transactional(readOnly = false, rollbackFor = DataAccessException.class)   
    Account register(Account account);   
}
