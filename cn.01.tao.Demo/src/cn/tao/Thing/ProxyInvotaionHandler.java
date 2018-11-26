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
	 *生成代理类 
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
	/***
	 * proxy 是代理类
	 * method 代理类所调用的
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		hello();
		Object result = method.invoke(object, args);
		hello();
		return result;
	}
	/***
	 * 下面可以是接口的方法
	 */
	public void hello(){
		System.out.println("你好类已被执行。。。");
	}

}
