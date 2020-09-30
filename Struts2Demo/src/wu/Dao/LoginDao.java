package wu.Dao;

public class LoginDao {
	public String Login(String username) {
		if ("wulex".equals(username)) {
			return "TRUE--val123"; 
		}
		return null; 
	}

}
