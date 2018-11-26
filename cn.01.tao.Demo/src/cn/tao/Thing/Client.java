package cn.tao.Thing;

public class Client {

	public static void main(String[] args) {
		Host host = new Host();
		ProxyInvotaionHandler pInvotaionHandler = new ProxyInvotaionHandler();
		pInvotaionHandler.setObject(host);
		Rent proxyRent = (Rent)pInvotaionHandler.getProxy();
		proxyRent.rentHouse();
	}

}
