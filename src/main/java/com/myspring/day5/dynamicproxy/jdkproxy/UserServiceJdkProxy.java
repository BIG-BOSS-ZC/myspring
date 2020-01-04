package com.myspring.day5.dynamicproxy.jdkproxy;

import com.myspring.day5.nono.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceJdkProxy{
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static UserService getUserService(UserService userService){
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                ((proxy, method, args) -> {
                    Object invoke;
                    if(method.getName().equals("deleteUser")){
                        invoke = method.invoke(userService, args);
                    }else {
                        System.out.println("[Info]"+format.format(new Date())
                                +" Method "+ method.getName() +" start invoked");
                        invoke = method.invoke(userService, args);
                        System.out.println("[Info]"+format.format(new Date())
                                +" Method "+ method.getName() +" finish invoked");
                    }
                    return invoke;
                }));
    }

}
