package com.myspring.day3;

import com.alibaba.druid.pool.DruidDataSource;
import com.myspring.day3.annotation.MyValue;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.Properties;

public class MyDS {

    private static DruidDataSource ds=null;
    @MyValue("jdbcUrl")
    private static String jdbcurl;
    @MyValue("myname")
    private static String username;
    @MyValue("password")
    private static String password;
    @MyValue("driverClass")
    private static String driverClass;

    public static void main(String[] args) {
        try {
           parseJdbc();
           ds=new DruidDataSource();
           ds.setUrl(jdbcurl);
           ds.setUsername(username);
           ds.setPassword(password);
           ds.setDriverClassName(driverClass);
            System.out.println(ds);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void parseJdbc(){
        try {
            //1.读取配置文件
            Properties properties=new Properties();
            properties.load(MyDS.class.getClassLoader()
                      .getResourceAsStream(
                            "jdbc.properties"));
            //2.得到注解
            Field[] fields=MyDS.class.getFields();
            for(Field f:fields){
                MyValue myValue = f.getAnnotation(MyValue.class);
                if(myValue==null){
                    continue;
                }
                String key=myValue.value();
                f.setAccessible(true);
                f.set(null,properties.getProperty(key));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
