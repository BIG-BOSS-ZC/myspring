package com.myspring.day5.dynamicproxy.jdkproxy;

import com.myspring.day5.nono.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceJdkProxy2 implements InvocationHandler{
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private UserService service;

    public UserService getUserService(UserService userService){
        this.service=userService;
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke;
        if(method.getName().equals("deleteUser")){
            invoke = method.invoke(service, args);
        }else {
            System.out.println("[Info]"+format.format(new Date())
                    +" Method "+ method.getName() +" start invoked");
            invoke = method.invoke(service, args);
            System.out.println("[Info]"+format.format(new Date())
                    +" Method "+ method.getName() +" finish invoked");
        }
        return invoke;
    }
}
