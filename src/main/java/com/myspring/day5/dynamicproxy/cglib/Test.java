package com.myspring.day5.dynamicproxy.cglib;


import com.myspring.day5.nono.UserService;
import com.myspring.day5.nono.UserServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;

public class Test {
    public static void main(String[] args) {
        // 保存动态生成的代理类的字节码
        long l1 = System.currentTimeMillis();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\test\\myspring\\src\\main\\java\\com\\myspring\\day5\\dynamicproxy\\cglib");
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService=new UserServiceImpl();
        com.myspring.day5.nono.UserService service = UserServiceJdkProxy.getUserService((com.myspring.day5.nono.UserService) userService);
        service.createUser();
        service.deleteUser();
        long l2 = System.currentTimeMillis();
        System.out.println("cglib动态代理：ms");
        System.out.println(l2-l1);
    }
}
