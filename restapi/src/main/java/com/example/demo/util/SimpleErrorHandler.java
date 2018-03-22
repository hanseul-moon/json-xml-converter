package com.example.demo.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("warning 발생");
        System.out.println(e.getLineNumber() + "행 :: " + e.getColumnNumber()+"열");
        throw new SAXException(e);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("(DTD 또는 XML Schema 문서 구조 위배)");
        System.out.println(e.getLineNumber() + "행 :: " + e.getColumnNumber()+"열");
        throw new SAXException(e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.print("(XML 권고안의 내용 위배)");
        System.out.println();
        System.out.println(e.getLineNumber() + "행 :: " + e.getColumnNumber()+"열");
        throw new SAXException(e);
	}

}
