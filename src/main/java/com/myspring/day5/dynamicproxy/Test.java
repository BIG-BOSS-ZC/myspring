package com.myspring.day5.dynamicproxy;

import com.myspring.day5.dynamicproxy.jdkproxy.UserServiceJdkProxy;
import com.myspring.day5.dynamicproxy.jdkproxy.UserServiceJdkProxy2;
import com.myspring.day5.nono.UserService;
import com.myspring.day5.nono.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        // 保存动态生成的代理类的字节码
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService=new UserServiceImpl();
        UserServiceJdkProxy2 u = new UserServiceJdkProxy2();
        UserService service=u.getUserService(userService);
        service.deleteUser();
        service.createUser();
        long l2 = System.currentTimeMillis();
        System.out.println("jdk动态代理：ms");
        System.out.println(l2-l1);
    }
}
