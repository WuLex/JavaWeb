package siso.wu.odd;

public class Client { 
	
	public static void main(String[] args) {
		 IService service =ServiceFactory.getService();
		 String result=service.doService();
		 System.out.println(result);
	}

}
