package com.myspring.day2.myioc.constractor;

import com.myspring.day1.bean.User;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {
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

        URL url=BeanFactory.class.getClassLoader().getResource(filePath);

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
            Class<?>[] paramType=new Class[elements1.size()];
            Object[] params=new Object[elements1.size()];
            for (int i=0;i<elements1.size();i++){
//                String name=e1.attributeValue("name");
                String ref=elements1.get(i).attributeValue("ref");
                Object param=beanMap.get(ref);
                params[i]=param;
                paramType[i]=param.getClass().getInterfaces()[0];
            }
            Object o=Class.forName(className)
                    .getDeclaredConstructor(paramType)
                    .newInstance(params);
            beanMap.put(id,o);
        }

    }

    public static void main(String[] args) throws Exception{
        BeanFactory.refresh("test1.xml");
        Client client = (Client) BeanFactory.getBean("client");
        client.add(new User("lzlsb","1999"));
    }
}
