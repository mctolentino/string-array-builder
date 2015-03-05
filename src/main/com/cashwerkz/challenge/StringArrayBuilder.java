package com.cashwerkz.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringArrayBuilder extends AbstractStringArrayBuilder{

	private List<String> stringList;
	
	public StringArrayBuilder(){
		stringList = new ArrayList<String>();
	}
	
	public StringArrayBuilder addToArray(String string){
		stringList.add(string);
		return this;
	}
	
	public String[] build(){
		return build(stringList, Sorter.ASC);
	}
	
	public String[] build(Comparator<String> comparator){
		return build(stringList, Sorter.CUSTOM, comparator);
	}
	
	public String[] build(Sorter sortBy){
		return build(stringList, sortBy);
	}	
	
}
