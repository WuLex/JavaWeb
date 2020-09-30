package siso.wu.odd;

public class ServiceFactory {

	public static IService getService() {
		String serviceName = "siso.wu.odd.Service";
		IService service = null;
		try {
			service = (IService) Class.forName(serviceName).newInstance();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return service;
	}
}
