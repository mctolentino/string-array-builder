package com.cashwerkz.challenge.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cashwerkz.challenge.StringArrayBuilder;

public class StringArrayBuilderTest {
	
	private StringArrayBuilder builder;
	private String[] result;
	
	@Before
	public void setUp(){
		builder = new StringArrayBuilder();
	}

	@Test
	public void testCreateStringArrayBuilder() {
		assertNotNull(builder);
		
		result = builder.build();
		
	}

}
