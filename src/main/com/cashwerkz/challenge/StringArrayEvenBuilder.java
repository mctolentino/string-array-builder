package com.cashwerkz.challenge;

import java.util.ArrayList;
import java.util.List;

// Include even indexed Strings on build only
public class StringArrayEvenBuilder extends AbstractStringArrayBuilder {

	private List<String> stringList;
	
	public StringArrayEvenBuilder(){
		stringList = new ArrayList<String>();
	}
	
	@Override
	public String[] build() {
		List<String> temp = new ArrayList<String>();
		
		for( int i = 0; i < stringList.size(); i ++ ){
			if( i % 2 == 0 ){
				temp.add(stringList.get(i));
			}
		}
		
		String[] stringArray = temp.toArray(new String[temp.size()]);
		
		return stringArray;
	}

	@Override
	public StringArrayEvenBuilder addToArray(String string) {
		stringList.add(string);
		return this;
	}
	

}
