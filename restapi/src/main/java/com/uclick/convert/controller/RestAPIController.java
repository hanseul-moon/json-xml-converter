package com.uclick.convert.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.StaxonUtils;

@RestController
public class RestAPIController {
	@RequestMapping(value="/xml2json",
    		method=RequestMethod.POST,
    		consumes="application/xml",
    		produces="application/json")
    public ResponseEntity<String> xtoj(HttpServletRequest request, 
			@RequestBody String xml) {
//    	Map<String,Object> map = new HashMap<String,Object>();
//    	map.put("xml2json", "success");

//    	String res = "";      		
//		try {
//			res = JsonConverter.convertXml(xml);
//		} catch (XmlParseException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Error parsing " + e.toString());
//		}
    	
    	String json = StaxonUtils.xml2json(xml);
        System.out.println("xml2json success \n"+json);
       
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
    
    @RequestMapping(value="/json2xml",
    		method=RequestMethod.POST,
    		consumes="application/json",
    		produces="application/xml")
    public ResponseEntity<String> jtox(HttpServletRequest request, 
			@RequestBody String json) {
    	
    	String xml = StaxonUtils.json2xml(json);
    	
//    	int rootTagIndex = xml.indexOf(">");
//    	int rootCloseTagIndex = xml.lastIndexOf("</") + 2;
//    	
//    	String rootTag = xml.substring(1,rootTagIndex);
//    	String rootCloseTag = xml.substring(rootCloseTagIndex, xml.length() - 2);  
//    	boolean boolean_rootTag = xml.substring(rootTagIndex).contains("<" + rootTag + ">");
//    	
//    	if(boolean_rootTag == true || rootTag.equals(rootCloseTag) == false) {
//    		xml = "<&#37;&#36;&#38;temp>\n" + xml + "</&#37;&#36;&#38;temp>";
//    	}
    	
        System.out.println("json2xml success \n"+xml);
        xml = "<%$%emp>" + xml + "</%$%emp>";
        
        return new ResponseEntity<String>(xml, HttpStatus.OK);
    }
    
    @RequestMapping(value="/status",
    		method=RequestMethod.GET,
    		produces="application/json")
    public ResponseEntity<Map<String,Object>> status() {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("status", "success");
        
        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
    }
    
    @RequestMapping(value="/uploadFile",
    		method=RequestMethod.POST,
    		produces="application/xml")
    public ResponseEntity<String> uploadJsonFile(HttpServletRequest request,
    		@RequestParam("file") MultipartFile file) throws IOException {
    	String json = new String(file.getBytes());
    	System.out.println("uploadJsonFile success \n" + json);
    	
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
}
