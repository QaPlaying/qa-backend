package com.qa.fun.qa.auth;

import com.qa.fun.qa.common.utils.XmlUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionsReader {
	
	public List<Pair<String, String>> readPermissions() throws JDOMException, IOException {
		List<Element> permissionElements = XmlUtils.readXmlTagFromFile("auth/permissions.xml");
		List<Pair<String, String>> permissions = new ArrayList<>();
		for (Element permissionElement : permissionElements) {
			permissions.add(new ImmutablePair<>(permissionElement.getAttributeValue("end-point"), permissionElement.getAttributeValue("role")));
		}
		
		return permissions;
	}
}
