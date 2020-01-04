import com.myspring.day1.app.ReflexTest;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        /*Car mycar= SimpleFactory.getCar("bmw");
        mycar.getName();*/

        SAXReader saxReader=new SAXReader();
        URL url= Client.class.getResource("applicationContext.xml");
        System.out.println(url);
        Document doc = saxReader.read(url);

        Element rootElement = doc.getRootElement();
        System.out.println(rootElement.getName());
        List<Element> elements = rootElement.elements();

        for(Element e:elements){
            List<Attribute> attributes = e.attributes();
            for(Attribute a:attributes){
                System.out.println(a.getName()+":"+a.getValue());
            }
        }
    }
}
