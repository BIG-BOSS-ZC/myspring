package com.myspring.day2.myioc.method;

import com.myspring.day1.bean.User;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory3 {
    //ioc容器
    private static Map<String,Object> beanMap=new HashMap<>();

    /**
     * 从ioc容器中取对象
     * @param beanName
     * @return Object
     * @throws Exception
     */
    public static Object getBean(String beanName) throws Exception {
        return beanMap.get(beanName);
    }

    /**
     * 初始化ioc容器
     * @param filePath
     */
    public static void refresh(String filePath) throws Exception{
        //拿到xml文件
        SAXReader saxReader=new SAXReader();

        URL url= BeanFactory3.class.getClassLoader().getResource(filePath);

        Document document = saxReader.read(url);
        //获取根节点beans
        Element rootElement = document.getRootElement();
        //子元素bean
        List<Element> elements = rootElement.elements();
        //<bean>获取id,class
        for(Element e0:elements){
            xmlParse(e0);
        }
    }

    public static void xmlParse(Element e0) throws Exception{
        String id=e0.attributeValue("id");
        String className=e0.attributeValue("class");

        //<constructor-arg>获取name,ref
        List<Element> elements1 = e0.elements();

        if(elements1.size()==0){
            //无参构造方法创建对象
            Class<?> cls=Class.forName(className);
            Object o=cls.newInstance();
            beanMap.put(id,o);
        }else {
            //有参构造方法创建对象
            Class<?> cls=Class.forName(className);
            Object o=Class.forName(className).newInstance();
            for (int i=0;i<elements1.size();i++){
                String name=elements1.get(i).attributeValue("name");
                String value=elements1.get(i).attributeValue("value");
                name="set"+name.substring(0,1).toUpperCase()+name.substring(1,name.length());
                Method method = cls.getMethod(name,String.class);
                method.invoke(o,value);
            }
            beanMap.put(id,o);
        }

    }

    public static void main(String[] args) throws Exception{
        BeanFactory3.refresh("test2.xml");
        User user = (User) BeanFactory3.getBean("user");
        System.out.println(user.toString());
    }
}
