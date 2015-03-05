*Builder Pattern* is very familiar because Java's StringBuilder is based on this design pattern.

In this particular solution, an *ArrayList* was used to contain individual strings passed into the builder.
While a string array that is manually allocated when new strings are added is an option, an ArrayList was used to take advantage of sorting using *Collections.sort(list, comparator)*.
Using the comparator would make extending the sorting algorithm more flexible.
The build method is where the ArrayList is converted to a normal String array. 


### Main Classes
- com.cashwerkz.challenge.AbstractStringArrayBuilder
  - abstract class with all the necessary methods for a generic String Array Builder.
  - has 2 abstract methods, build() and addToArray().
  - the abstract methods would help make the builder more extendible.
- com.cashwerkz.challenge.StringArrayBuilder
  - extends the abstract builder class.
- com.cashwerkz.challenge.StringArrayEvenBuilder
  - was just playing around, creating a different build method.

### Test Class
- com.cashwerkz.challenge.test.StringArrayBuilderTest
  - contains all the test cases. Test case methods:
   - public void testCreateStringArrayBuilder() 
   - public void testAddStringsToArrayAndBuildAscending
   - public void testAddStringsToArrayAndBuildDescending
   - public void testAddStringsToArrayAndBuildFifo
   - public void testAddStringsToArrayAndBuildWithCustomComparator
   - public void testOnlyAddEvenIndexedStringsToResultingArray

	
### Takeaways
- this code can still be refactored a lot
- could experiment with different approaches. 
	- (Arrays.sort and using a manually allocted string array as individual string container)
- improve/cleaner method overloading 
