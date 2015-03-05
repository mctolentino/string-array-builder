package com.cashwerkz.challenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStringArrayBuilder {
	
	public enum Sorter {
		ASC, DESC, FIFO, CUSTOM
	}
	
	public abstract String[] build();
	
	public abstract AbstractStringArrayBuilder addToArray(String string);
	
	protected String[] build(List<String> list, Comparator<String> comparator){
		return build(list, Sorter.CUSTOM, comparator);
	}
	
	protected String[] build(List<String> list, Sorter sortBy){
		list = sortList(list, sortBy, null);
		String[] stringArray = list.toArray(new String[list.size()]);
		
		return stringArray;
	}
	
	protected String[] build(List<String> list, Sorter sortBy, Comparator<String> comparator){
		list = sortList(list, sortBy, comparator);
		String[] stringArray = list.toArray(new String[list.size()]);
		
		return stringArray;
	}
	
	protected List<String> sortList(List<String> stringList, Sorter sortBy, Comparator<String> comparator){
		
		switch (sortBy) {
		case ASC: 
			Collections.sort(stringList);
			break;
		case DESC: 
			Collections.sort(stringList, Collections.reverseOrder());
			break;
		case FIFO: 
			break;
		case CUSTOM: 
			Collections.sort(stringList, comparator);
			break;
		}
		
		return stringList;
	}

}
