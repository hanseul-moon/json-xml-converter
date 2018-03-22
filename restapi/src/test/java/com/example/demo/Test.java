package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.demo.util.Xml2JsonUtils;

public class Test {

    public static void main(String[] args) throws Exception {
        String source = "";//getString("config.xml");
//        System.out.println("\"config.xml\" validated ::"
//                + Xml2JsonUtils.isValidatedForString(source.toString())
//                + "\n");

        source = "<employees>\r\n" + 
        		"<employee>\r\n" + 
        		"<firstName>John</firstName> <lastName>Doe</lastNa me>\r\n" + 
        		"</employee>\r\n" + 
        		"<employee>\r\n" + 
        		"<firstName>Anna</firstName> <lastName>Smith</lastName>\r\n" + 
        		"</employee>\r\n" + 
        		"<employee>\r\n" + 
        		"<firstName>Peter</firstName> <lastName>Jones</lastName>\r\n" + 
        		"</employee>\r\n" + 
        		"</employees>";
        source = "false";
        System.out.println("\"employ 결과\" validated ::"
                + Xml2JsonUtils.isXMLValid(source)
                + "\n");

        //source = getString("configOfNotValidated2.xml");
//        System.out.println("\"configOfNotValidated2.xml\" validated ::"
//                + Xml2JsonUtils.isValidatedForString(source.toString())
//                + "\n");

//        System.out.println("*******************************");
//        System.out.println("\"config.xml\" validated :: "+Xml2JsonUtils.isVaildated("config.xml")+"\n");
//        System.out.println("\"configOfNotValidated.xml\" validated :: "+Xml2JsonUtils
//                .isVaildated("configOfNotValidated.xml")+"\n");
//        System.out.println("\"configOfNotValidated2.xml\" validated :: "+Xml2JsonUtils
//                .isVaildated("configOfNotValidated2.xml"));
    }

    public static String getString(String name) {
        File file = new File(name);
        BufferedReader br;
        StringBuffer source = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(
                    file)));
            source = new StringBuffer();
            String temp = null;

            while ((temp = br.readLine()) != null) {
                source.append(temp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return source.toString();

    }
}