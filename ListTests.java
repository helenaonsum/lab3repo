import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ListTests {
    static class TestStringChecker implements StringChecker {
    @Override
        public boolean checkString(String s) {
            // Example: A StringChecker that allows strings containing "e"
            return s.contains("e");
        }
    }
    
	@Test 
	public void testFilter() {
        List <String> input1 = new ArrayList<>(List.of("test", "boo" ));
        List <String> filteredList = ListExamples.filter(input1, new TestStringChecker());
        List <String> expectedResult = new ArrayList<>(List.of("test"));
        assertEquals(expectedResult, filteredList);
	}
    @Test
    public void testFilter2() {
        List <String> input1 = new ArrayList<>(List.of("test", "three", "blob", "nope" ));
        List <String> filteredList = ListExamples.filter(input1, new TestStringChecker());
        List <String> expectedResult = new ArrayList<>(List.of("test", "three", "nope"));
        assertEquals(expectedResult, filteredList);
    }
    @Test 
    public void testMerge() {
        List <String> str1 = new ArrayList<>(List.of("apple", "banana", "coconut"));
        List <String> str2 = new ArrayList<>(List.of("caramel", "drama"));
        List <String> expectedResult = new ArrayList<>(List.of("apple", "banana", "caramel", "coconut", "drama"));
        List <String> mergedList = ListExamples.merge(str1, str2);
        assertEquals(expectedResult, mergedList);
        }
    @Test
       public void testMerge2() {
        List <String> str1 = new ArrayList<>(List.of("apple"));
        List <String> str2 = new ArrayList<>(List.of("caramel", "drama"));
        List <String> expectedResult = new ArrayList<>(List.of("apple", "caramel", "drama"));
        List <String> mergedList = ListExamples.merge(str1, str2);
        assertEquals(expectedResult, mergedList);
        }
}

/*class ListExamples {

  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }
  */
  
  