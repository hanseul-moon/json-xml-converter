package com.example.demo.util;

public class Json2xmlUtils {

	public static String attachRootTag(String xml) {
		
		
    	int rootTagIndex = xml.indexOf(">");
    	int rootCloseTagIndex = xml.lastIndexOf("</") + 2;
    	
    	String rootTag = xml.substring(1,rootTagIndex);
    	String rootCloseTag = xml.substring(rootCloseTagIndex, xml.length() - 2);  
    	boolean boolean_rootTag = xml.substring(rootTagIndex).contains("<" + rootTag + ">");
    	
    	if(boolean_rootTag == true || rootTag.equals(rootCloseTag) == false) {
    		xml = "<t>"+xml+"</t>";
    	}
    	return xml;
	}
	
	public static String xmlMaker(String json) {
		
		json = Json2xmlUtils.arrayJsonCheck(json);
		
		boolean jsonValid = JSONUtils.isJSONValid(json);
    	System.out.println(jsonValid);
    	String xml = "";
    	
    	if(jsonValid == true) {
    		xml = Json2xmlUtils.converter(json);  
    		xml = Json2xmlUtils.attachRootTag(xml);
    		//xml = Json2xmlUtils.number2Code(xml);
    	}else {
    		xml = "false";
    	}
		return xml;
	}
	
	public static String converter(String json) {
		
		String xml = StaxonUtils.json2xml(json);
		return xml;
	}
	
	public static String number2Code(String json) {
		
		json = json.replaceAll("0", "NubmerToCodeExecuteZERO");
		json = json.replaceAll("1", "NubmerToCodeExecuteONE");
		json = json.replaceAll("2", "NubmerToCodeExecuteTOW");
		json = json.replaceAll("3", "NubmerToCodeExecuteTHREE");
		json = json.replaceAll("4", "NubmerToCodeExecuteFOUR");
		json = json.replaceAll("5", "NubmerToCodeExecuteFIVE");
		json = json.replaceAll("6", "NubmerToCodeExecuteSIX");
		json = json.replaceAll("7", "NubmerToCodeExecuteSEVEN");
		json = json.replaceAll("8", "NubmerToCodeExecuteEIGHT");
		json = json.replaceAll("9", "NubmerToCodeExecuteNINE");
		System.out.println("number함수:"+json);
		return json;
	}
	
	public static String arrayJsonCheck(String json) {
		String startMark = json.trim().substring(0, 2);
		if(startMark.equals("[")) {
			json = "false";
		}
		
		return json;
	}
}
