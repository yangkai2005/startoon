package org.j2eeframework.startoon.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Unit {

	private Properties properties = new Properties();
	private static final Unit instance = new Unit();
	private List<Map<String, String>> units = new ArrayList<Map<String, String>>();

	private Unit() {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("unit.properties");
		try {
			properties.load(in);
			for(Object key : properties.keySet()) {
				String k = (String) key;
				String v = properties.getProperty(k);
				Map<String, String> unit = new HashMap<String, String>();
				unit.put("id", k);
				unit.put("name", v);
				units.add(unit);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Unit getInstance() {
		return instance;
	}

	public List<Map<String, String>> getUnits() {
		
//		Collections.sort(units, new Comparator<Map<String, String>>() {
//
//			@Override
//			public int compare(Map<String, String> o1, Map<String, String> o2) {
//				
//				Map.Entry<String, String>
//				
//				o1.keySet();
//				return 0;
//			}
//		});
		
		return units;
	}

}
