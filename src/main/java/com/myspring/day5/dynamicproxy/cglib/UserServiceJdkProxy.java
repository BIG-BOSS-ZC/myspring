package com.myspring.day5.dynamicproxy.cglib;

import com.myspring.day5.nono.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceJdkProxy {
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static UserService getUserService(UserService userService){
        return (UserService) Enhancer.create(userService.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("[Info]"+format.format(new Date())
                        +" Method "+ method.getName() +" start invoked");
                Object invoke = method.invoke(userService, args);

//                Object invoke=methodProxy.invoke(userService,args);
//                Object invoke=methodProxy.invokeSuper(proxy,args);
                System.out.println("[Info]"+format.format(new Date())
                        +" Method "+ method.getName() +" finish invoked");
                return invoke;
            }
        });
    }

}
