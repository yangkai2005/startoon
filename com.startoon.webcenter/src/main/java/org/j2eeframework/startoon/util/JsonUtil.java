package org.j2eeframework.startoon.util;

import java.util.ArrayList;
import java.util.List;

import org.j2eeframework.startoon.entity.Category;

public class JsonUtil {

	
	public static String getJsonString(Category category) {
		 
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		
		sb.append("data:");
		sb.append("'");
		sb.append(category.getName());
		sb.append("'");
		
		sb.append(",");
		
		sb.append("attr:{");
		sb.append("id:");
		sb.append("'");
		sb.append(category.getId());
		sb.append("'");
		sb.append("}");
		
		sb.append(",");
		
		sb.append("state:'open'");
		
		if(category.getCategories()!=null && category.getCategories().size()>0) {
			sb.append(",");
			
			sb.append("children: [");
			boolean flag = false;
			for(Category c: category.getCategories()) {
				if(flag) {
					sb.append(",");
				}
				sb.append(getJsonString(c));
				
				flag = true;
			}
			
			sb.append("]");
		}
		
		sb.append("}");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Category c1  = new Category();
		c1.setId(1L);
		c1.setName("root");
		
		List<Category> list = new ArrayList<Category>();
		
		Category child1  = new Category();
		child1.setId(1L);
		child1.setName("child1");
		
		Category child3  = new Category();
		child3.setId(1L);
		child3.setName("child3");
		Category child4  = new Category();
		child4.setId(1L);
		child4.setName("child4");
		List<Category> l = new ArrayList<Category>();
		l.add(child3);
		l.add(child4);
		child1.setCategories(l);
		
		
		Category child2  = new Category();
		child2.setId(1L);
		child2.setName("child2");
		
		list.add(child2);
		list.add(child1);
		
		c1.setCategories(list);
		
		
		System.out.println(getJsonString(c1));
	}
	
}
