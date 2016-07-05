import static org.junit.Assert.*;

import java.util.HashSet;


import org.junit.Test;

public class Assignment3Test {

	@Test
	public void testSearchelement() {
		HashSet<Integer> ranarray = new HashSet<Integer>();
		ranarray.add(25);
		ranarray.add(50);
		ranarray.add(15);
		boolean k = Assignment3.searchElement(ranarray,25);
		assertEquals(k,true);
	}

}
