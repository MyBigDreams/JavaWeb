package cn.tao.Thing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyInvotaionHandler implements InvocationHandler {
	private Object object;
	
	public void setObject(Object object) {
		this.object = object;
	}
	/**
	 *���ɴ����� 
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
	/***
	 * proxy �Ǵ�����
	 * method �����������õ�
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		hello();
		Object result = method.invoke(object, args);
		hello();
		return result;
	}
	/***
	 * ��������ǽӿڵķ���
	 */
	public void hello(){
		System.out.println("������ѱ�ִ�С�����");
	}

}
