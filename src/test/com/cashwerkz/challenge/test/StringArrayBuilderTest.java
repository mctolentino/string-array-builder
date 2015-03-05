package com.cashwerkz.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cashwerkz.challenge.AbstractStringArrayBuilder.Sorter;
import com.cashwerkz.challenge.StringArrayBuilder;
import com.cashwerkz.challenge.StringArrayEvenBuilder;

public class StringArrayBuilderTest {
	
	private StringArrayBuilder builder;
	private StringArrayEvenBuilder evenBuilder;
	private String[] result;
	private String test1, test2, test3, test4, test5;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp(){
		test1 = "TEST1"; 
		test2 = "TEST2"; 
		test3 = "TEST3";
		test4 = "TEST4";
		test5 = "TEST5";
		builder = new StringArrayBuilder();
		evenBuilder = new StringArrayEvenBuilder();
	}

	@Test
	public void testCreateStringArrayBuilder() {
		assertNotNull(builder);
		result = builder.build();
	}
	
	@Test
	public void testAddStringsToArrayAndBuildAscending(){
		builder.addToArray(test1);
		builder.addToArray(test4);
		builder.addToArray(test5);
		builder.addToArray(test3);
		builder.addToArray(test2);
		
		result = builder.build();
		
		assertEquals(test1, result[0]);
		assertEquals(test2, result[1]);
		assertEquals(test3, result[2]);
		assertEquals(test4, result[3]);
		assertEquals(test5, result[4]);
		
		exception.expect(ArrayIndexOutOfBoundsException.class);
		@SuppressWarnings("unused")
		String test6 = result[5];
	}
	
	@Test
	public void testAddStringsToArrayAndBuildDescending(){
		
		builder.addToArray(test4);
		builder.addToArray(test1);
		builder.addToArray(test3);
		builder.addToArray(test5);
		builder.addToArray(test2);
		
		result = builder.build(Sorter.DESC);
		
		assertEquals(test5, result[0]);
		assertEquals(test4, result[1]);
		assertEquals(test3, result[2]);
		assertEquals(test2, result[3]);
		assertEquals(test1, result[4]);
		
	}
	
	@Test
	public void testAddStringsToArrayAndBuildFifo(){
		
		builder.addToArray(test4);
		builder.addToArray(test1);
		builder.addToArray(test3);
		builder.addToArray(test5);
		builder.addToArray(test2);
		
		result = builder.build(Sorter.FIFO);
		
		assertEquals(test4, result[0]);
		assertEquals(test1, result[1]);
		assertEquals(test3, result[2]);
		assertEquals(test5, result[3]);
		assertEquals(test2, result[4]);
	}
	
	@Test
	public void testAddStringsToArrayAndBuildWithCustomComparator(){
		test1 = "C";
		test2 = "A";
		test3 = "B";
		test4 = "a";
		test5 = "b";
		
		builder.addToArray(test1);
		builder.addToArray(test2);
		builder.addToArray(test3);
		builder.addToArray(test4);
		builder.addToArray(test5);
		
		result = builder.build(new Comparator<String>() {

			@Override
			public int compare(String obj1, String obj2) {
				if (obj1 == obj2) {
			        return 0;
			    }
			    if (obj1 == null) {
			        return -1;
			    }
			    if (obj2 == null) {
			        return 1;
			    }
				return obj1.toLowerCase().compareTo(obj2.toLowerCase()) ;
			}
		});
		
		assertEquals(test2, result[0]);
		assertEquals(test4, result[1]);
		assertEquals(test3, result[2]);
		assertEquals(test5, result[3]);
		assertEquals(test1, result[4]);
	}
	
	@Test
	public void testOnlyAddEvenIndexedStringsToResultingArray(){
		
		evenBuilder.addToArray(test4);
		evenBuilder.addToArray(test1);
		evenBuilder.addToArray(test3);
		evenBuilder.addToArray(test5);
		evenBuilder.addToArray(test2);
		
		result = evenBuilder.build();
		
		assertEquals(test4, result[0]);
		assertEquals(test3, result[1]);
		assertEquals(test2, result[2]);
	}

}
