package my;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author 孟享广
 * @date 2020-10-09 2:50 下午
 * @description
 */
public class Dom4jText {
    @Test
    public void test1() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    /**
     *
     */
    @Test
    public void test2() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);

        List<Element> books = rootElement.elements("book");
        for (int i = 0; i < books.size(); i++) {

        }
    }
}
