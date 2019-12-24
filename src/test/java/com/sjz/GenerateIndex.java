package com.sjz;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

/**
 * @author yang
 * Date 2019/12/10 22:50
 */
public class GenerateIndex {
    @Test
    public void gen() throws ParserConfigurationException, IOException, SAXException {
        ClassPathResource res1 = new ClassPathResource("source.xml");
        EncodedResource encodedResource = new EncodedResource(res1,"UTF-8");
        DocumentBuilderFactory fa = DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = fa.newDocumentBuilder();
        Document doc1 = db1.parse(encodedResource.getInputStream());
        Element element1 = doc1.getDocumentElement();
        NodeList nodes = element1.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            System.out.println(item);
        }


    }


}
