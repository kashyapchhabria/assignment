import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Assignment1Test {

	@Test
	public void testReadfile() {
		 Map<String,Integer> ageStats = Assignment1.readFile("/home/kashyap/workspace/assignments/test.csv");
        Map<String, Integer> expectedStats = new HashMap<String,Integer>();
        expectedStats.put("23",3);        //expectedStats.put(26, 3);
        assertEquals(ageStats,expectedStats);
		}

}