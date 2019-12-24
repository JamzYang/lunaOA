package com.sjz;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author yang
 * Date 2019/12/10 23:30
 */
public class SaxDom {

    @Test
    public void gen2() throws ParserConfigurationException, IOException, SAXException, DocumentException {
        SAXReader reader = new SAXReader();
        Document read = reader.read(new File("src/test/resources/source.xml"));
        Document document = read.getDocument();
        String nodeTypeName = document.getNodeTypeName();

        Element rootElement = read.getRootElement();
        Element tagsA = getTagsA(rootElement);
        List<Element> p = rootElement.elements();
        HashMap<String, String> map = new HashMap<>();
        for (Element element : p) {
            if(element.getName().equals("body")){
                List<Element> ps = element.elements();
                for (Element p1 : ps) {
                    String name = p1.getName();
                    if(p1.getName().equals("p")){
                        List<Element> nodesP = p1.elements();
                        for (Element element1 : nodesP) {
                            String key = "";
                            String value = "";
                            if(element1.getName().equals("a")){
                                key = element1.attributeValue("href");
                                List<Element> elements = element1.elements();
                                for (Element element2 : elements) {
                                    if(element2.getName().equals("font")){
                                        value = element2.getText();
                                    }
                                }
                            }
                         map.put(key,value);
                        }
                    }
                }
            }
        }
        System.out.println("");

    }

    public Element getTagsA(Element ele){
        List<Element> eles = ele.elements();
        Element a = null;
        for (Element el : eles) {
            if(el.getName().equals("a")){
                a = el;
                return el;
            }else{
                getTagsA(el);
            }
        }
        return a;
    }
}
