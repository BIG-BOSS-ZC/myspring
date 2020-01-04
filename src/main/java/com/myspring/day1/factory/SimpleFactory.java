package com.myspring.day1.factory;

public class SimpleFactory {
    public static Car getCar(String brandname) throws Exception{
        if(brandname.equalsIgnoreCase("bmw")){
            Class<?> bmw = Class.forName("com.myspring.day1.factory.BMW");
            return (Car)bmw.newInstance();
        }else if(brandname.equalsIgnoreCase("benz")){
            Class<?> benz = Class.forName("com.myspring.day1.factory.Benz");
            return (Car)benz.newInstance();
        }else {
            return null;
        }
    }

    public static Car getCar2(String brandname){
        Car car=null;
        try {
            Class<?> cls = Class.forName(brandname);
            car=(Car) cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
}
