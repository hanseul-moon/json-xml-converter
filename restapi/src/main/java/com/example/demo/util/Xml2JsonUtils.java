package com.example.demo.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * xml 내용을 String값으로 받아와 xml의 유효성을 검사하는 유틸클래스
 * 
 * @author Lee sung-hee
 * @since 2009-07-28
 * 
 */
public class Xml2JsonUtils extends DefaultHandler {

    private static final Xml2JsonUtils instance = new Xml2JsonUtils();

    private static Xml2JsonUtils getInstance() {
        return instance;
    }

    /**
     * 입력받은 파일명의 xml의 유효성을 검사한다.
     * 
     * @param fileName	검사할 xml 파일 명
     * @return validation이 된 xml 인지 확인
     */
//    public static boolean isVaildated(String fileName) {
//        boolean result = true;
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        factory.setNamespaceAware(true);
//        factory.setValidating(true);
//        SAXParser parser;
//
//        try {
//            factory.setFeature(
//                    "http://apache.org/xml/features/validation/schema", true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            parser = factory.newSAXParser();
//            parser.parse(fileName, Xml2JsonUtils.getInstance());
//
//        } catch (SAXException e) {
//            result = false;
//        } catch (IOException e) {
//            System.out.println("존재하지 않는 문서");
//            result = false;
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }

    /**
     * xml 내용을 String 으로 받와 검사한다
     * 
     * @param source 검사할 xml 문자열
     * @return
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     * @throws UnsupportedEncodingException 
     */
//    public static boolean isValidatedForString(String source) {
//        boolean result = true;
//
//        InputStream stream = new ByteArrayInputStream(source.getBytes());
//
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        factory.setNamespaceAware(true);
//        factory.setValidating(true);
//        SAXParser parser;
//
//        try {
//            factory.setFeature(
//                    "http://apache.org/xml/features/validation/schema", true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            parser = factory.newSAXParser();
//            parser.parse(stream, Xml2JsonUtils.getInstance()); 
//            
//
//        } catch (SAXException e) {
//            result = false;
//        } catch (IOException e) {
//            System.out.println("존재하지 않는 문서");
//            result = false;
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
    
    public static String converter(String xml) {
    	
    	String json = StaxonUtils.xml2json(xml);
    	return json;
    }
    
    public static String detachRootTag(String xml) {
    	
    	xml = xml.replace("<datas>","").replace("</datas>", "");
    	return xml;
    };
    
    public static String jsonMaker(String xml) {
    	
    	boolean xmlValid = Xml2JsonUtils.isXMLValid(xml);
   	
    	String json = "";    	
    	System.out.println("xml validation : " + xmlValid);
    	
    	if(xmlValid == true) {
    		json = Xml2JsonUtils.converter(xml);
    	}else {
    		json = " ";
    	}
    	return json;
    }

    public static boolean isXMLValid(String xml){
    	
    	boolean result = true;
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setValidating(false);			// 이게 필요한건지?????????
    	factory.setNamespaceAware(true);		// 이게 필요한건지?????????
    	DocumentBuilder db;	
    	
		try {
			db = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			result = false;
			db = null;
			e.printStackTrace();
		}
    	
    	try {
			db.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		} catch (SAXException e) {
			result = false;
			e.printStackTrace();
		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		}
    	return result;
    }
}