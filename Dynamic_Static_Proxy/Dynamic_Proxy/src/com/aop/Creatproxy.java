package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Creatproxy implements InvocationHandler {
    private  Object target;
    
    public Object create(Object target){
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return proxy;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("荆州寻找客户需要的产品");
        System.out.println("跟客户确认物品");
        Object obj = method.invoke(target, args);
        System.out.println("完成本次海淘");
        return null;
    }
}
