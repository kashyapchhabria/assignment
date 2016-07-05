import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Assignment2Test {
	static Map<String, List<String>> expectedStats = new HashMap<String, List<String>>();
	@Test
	public void testReadfile() {
		Map<String, List<String>> coursestats = Assignment2.readFile("/home/kashyap/workspace/assignments/test2.csv");
		 Map<String, List<String>> expectedStats = new HashMap<String, List<String>>();
		 List<String> list = new ArrayList<>();
		 list.add("Electrical");
		 list.add("ComputerScience");
		 list.add("Bio");
		 expectedStats.put("AnnaUniv",list); 
		 list.clear();
		 list.add("Bio");
		 expectedStats.put("Svce",list);
		 assertEquals(coursestats,expectedStats);
	}

}
