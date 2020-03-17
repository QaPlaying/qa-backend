package com.qa.fun.qa.common.utils;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class XmlUtils {
	
	public static List<Element> readXmlTagFromFile(String fileName) throws JDOMException, IOException {
		File file = new File(XmlUtils.class.getClassLoader().getResource("auth/permissions.xml").getFile());
		SAXBuilder builder = new SAXBuilder();

		Document document = builder.build(file);
		Element rootNode = document.getRootElement();
		
		List children = rootNode.getChildren();
		return children;
	}
}
