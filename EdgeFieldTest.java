import static org.junit.Assert.*;

import org.junit.Test;

public class EdgeFieldTest {

	@Test
	public void exampleTest() {
		EdgeField ef = new EdgeField("3|aField|fieldname");
		System.out.println(ef);
		ef.setDataType(3);
		ef.setIsPrimaryKey(true);
		System.out.println(ef);
	}

}
