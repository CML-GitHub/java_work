package com.company;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class UMLutil {
    public Object getBean() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File("config.xml"));
            
            
            NodeList nodeList1 = doc.getElementsByTagName("className");
            Node classNode = nodeList1.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            System.out.println(cName);
            System.out.println("----------------------");
            
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        
        return null;
        /*SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(new File("config.xml"));
            org.dom4j.Element elem = ((org.dom4j.Document) doc).getRootElement();
            Element e = elem.element("className");
            String cName = e.getText();
            System.out.println(cName);
            System.out.println("--------------------------");
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        }catch (DocumentException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return null;*/
    }
}
