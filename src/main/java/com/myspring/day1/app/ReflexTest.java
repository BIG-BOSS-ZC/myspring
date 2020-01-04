package com.myspring.day1.app;

import com.myspring.day1.bean.User;
import com.myspring.day1.dao.UserDao;
import com.myspring.day1.dao.impl.UserDaoImpl;

import java.lang.reflect.*;

public class ReflexTest {
    public static void main(String[] args) throws Exception {
        /*Class<?> cls=Class.forName("com.myspring.day1.bean.User");
        System.out.println("成员变量-------------");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field f:declaredFields){
            String m= Modifier.toString(f.getModifiers());
            System.out.println(m+" "+f.getType().getSimpleName()+"( "+f.getType().getSimpleName());
        }

        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for(Constructor<?> c:constructors){
            String m=Modifier.toString(c.getModifiers());
            System.out.println(m+" "+c.getName()+"( ");

            Parameter[] parameters = c.getParameters();

        }*/
        User u1 = (User) getObject("com.myspring.day1.bean.User");
        setField(u1,"id","999");
        setField(u1,"name","lzlsb");

        User u2= (User) getObject("com.myspring.day1.bean.User");
        myInvoke(u2,"setId","12306");
        myInvoke(u2,"setName","invoke");
        System.out.println(u2);

    }

    public static Object getObject(String className,Object... params) throws Exception {
        Class<?> cls=Class.forName(className);
        if(params.length==0){
             return cls.getDeclaredConstructor().newInstance();
        }else {
            Class<?>[] paramType=new Class[params.length];
            for(int i=0;i<params.length;i++){
                paramType[i]=params[i].getClass();
            }
            return cls.getDeclaredConstructor(paramType).newInstance(params);
        }
    }

    public static void setField(Object obj, String fieldName, Object value) throws Exception {
        Class<?> cls = obj.getClass();
        Field field = cls.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj,value);
    }
    // 在调用原方法的基础上，添加日志和方法调用时长的功能
    // 日志：添加一个打印即可，打印内容不限；
    // 调用时长：在方法的开始和结束的地方，获取系统毫秒数，然后相减，然后打印该时长
    public static void myInvoke(Object obj, String methodName, Object... params) throws Exception {
        long time0 = System.currentTimeMillis();
        System.out.println("[myInvoke] starting,time0="+time0);
        Class<?> cls = obj.getClass();
        Class<?>[] paramType=new Class[params.length];
        for(int i=0;i<params.length;i++){
            paramType[i]=params[i].getClass();
        }
        Method method = cls.getMethod(methodName, paramType);
        method.invoke(obj,params);
        long time1=System.currentTimeMillis();
        System.out.println("[myInvoke] finished,time1="+time1);
        long ss=time1-time0;
        System.out.println("[myInvoke] 用了 "+ss+" ms");
    }
}
