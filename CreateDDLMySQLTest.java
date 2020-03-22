import static org.junit.Assert.*;

import org.junit.Test;

public class CreateDDLMySQLTest {

	@Test
	public void simpleTest() {
		// Note that the object number (first field) is arbitrary but should be 
		// unique and will be needed in the future
		EdgeTable et = new EdgeTable("1|my_table");
		EdgeField ef1 = new EdgeField("10|field1");
		EdgeField ef2 = new EdgeField("20|field2");
		// Note that these field numbers need to match the numbers in ef1 and ef2
		// Wouldn't it be easier if we could just pass a list of EdgeField instances??
		et.addNativeField(10);
		et.addNativeField(20);

		// makeArrays() needs to be called to store loaded fields and relationships into some internal arrays.
		// Wouldn't it be easier if this happened automatically when needed, or when a new EdgeField added?
		et.makeArrays();
		CreateDDLMySQL mysql = new CreateDDLMySQL(new EdgeTable[]{et}, new EdgeField[]{ef1, ef2});
		// overriding the createDDL method like this removes the dialog pop 
		// and makes this test a little more "FIRST"
		 mysql.createDDL("SimpleMySQLDB");
		//mysql.createDDL();
		String sqlOut = mysql.sb.toString();
		System.out.println(sqlOut);
		assertNotNull("Generated SQL should not be null", sqlOut);
		assertFalse("Generated SQL should not be empty string", sqlOut.isEmpty());
		
		assertTrue("String should have 'TABLE'", sqlOut.toUpperCase().contains("TABLE"));
		assertTrue("String should have Table's name", sqlOut.toUpperCase().contains(et.getName().toUpperCase()));
		
		assertTrue("String should have column 1's name", sqlOut.toUpperCase().contains(ef1.getName().toUpperCase()));
		assertTrue("String should have column 2's name", sqlOut.toUpperCase().contains(ef2.getName().toUpperCase()));

	}

}
