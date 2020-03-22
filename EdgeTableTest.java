import static org.junit.Assert.*;

import org.junit.Test;

public class EdgeTableTest {

	@Test
	public void createTableNoColumnsNorRefsTest() {
		EdgeTable et = new EdgeTable("3|simple_table");
		assertNotNull(et);
		// not calling makeArrays() is probably the biggest source of NullPointerExceptions in unit tests
		et.makeArrays();
		System.out.println(et);
	}

	@Test
	public void createTableWithColumns() {
		EdgeTable et = new EdgeTable("99|my_table_columns");
		assertNotNull(et);
		EdgeField ef1 = new EdgeField("10|mtc_col1");
		assertNotNull(ef1);
		et.addNativeField(10);
		// not calling makeArrays() is probably the biggest source of NullPointerExceptions in unit tests		
		et.makeArrays();
		System.out.println(et);
		System.out.println(ef1);
		// you can add any number you want here as there's no magic linking to EdgeField instances
		et.addNativeField(999);
		et.makeArrays();
		assertEquals("should be 2: columns #10 and #99", et.getNativeFieldsArray().length, 2);
		System.out.println(et);
	}
}
