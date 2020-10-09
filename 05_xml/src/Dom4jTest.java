import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/books.xml");

        System.out.println(document);
    }

    @Test
    public void test2() throws Exception {
        //读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //通过document对象获取根元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);

        //通过根元素获取book标签对象
        List<Element> books = rootElement.elements("book");

        //遍历、处理，每个标签转换为ook类
        for (Element book: books) {
            //asXLM() 把xml标签对象 转换为标签字符串
//            System.out.println(book.asXML());

            Element nameElement = book.element("name");
            //getText() 可以获取标签中的文本内容
            String nameElementText = nameElement.getText();
//            System.out.println(nameElementText);

            //直接获取 指定 签名的文本内容
            String priceElementText = book.elementText("price");
//            System.out.println(priceElementText);

            String autuorElementText = book.elementText("autuor");
//            System.out.println(autuorElementText);

            //获取属性值
            String snAttributeValue = book.attributeValue("sn");

//            Book book1 = new Book(snAttributeValue, nameElementText, Double.parseDouble(priceElementText), autuorElementText);
//            System.out.println(book1);
        }

    }
}
