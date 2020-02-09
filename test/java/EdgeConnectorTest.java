import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeConnectorTest {
	EdgeConnector testObj;

	@Before
	public void setUp() throws Exception {
		testObj = new EdgeConnector("1|2|3|testStyle1|testStyle2");
	}

	@Test
	public void testGetNumConnector() {
		// Example of how a value can be passed into a test
		String opt1Str = System.getProperty("optionone");
		final long opt1;
		if (opt1Str == null) {
			opt1 = 1;
		}
		else {
			opt1 = Long.parseLong(opt1Str);
		}
		assertEquals("numConnector was intialized to 1 so it should be 1",(long)opt1,testObj.getNumConnector());
	}

	@Test
	public void testGetEndPoint1() {
		assertEquals("EndPoint1 was intialized to 2",2,testObj.getEndPoint1());
	}

	@Test
	public void testGetEndPoint2() {
		assertEquals("EndPoint2 was intialized as 3",3,testObj.getEndPoint2());
	}

	@Test
	public void testGetEndStyle1() {
		assertEquals("endStyle1 was intialized to \"testStyle1\"","testStyle1",testObj.getEndStyle1());
	}

	@Test
	public void testGetEndStyle2() {
		assertEquals("endStyle1 was intialized to \"testStyle1\"","testStyle2",testObj.getEndStyle2());
	}

	@Test
	public void testGetIsEP1Field() {
		assertEquals("isEP1Field should be false",false,testObj.getIsEP1Field());
	}

	@Test
	public void testGetIsEP2Field() {
		assertEquals("IsEP2Field should be false",false,testObj.getIsEP2Field());
	}

	@Test
	public void testGetIsEP1Table() {
		assertEquals("isEP1Table should be false",false,testObj.getIsEP1Table());
	}

	@Test
	public void testGetIsEP2Table() {
		assertEquals("isEP2Table should be false",false,testObj.getIsEP2Table());
	}

	@Test
	public void testSetIsEP1Field() {
		testObj.setIsEP1Field(false);
		assertEquals("isEP1Field should be what you set it to",false,testObj.getIsEP1Field());
	}

	@Test
	public void testSetIsEP2Field() {
		testObj.setIsEP2Field(false);
		assertEquals("isEP2Field should be what you set it to",false,testObj.getIsEP2Field());
	}

	@Test
	public void testSetIsEP1Table() {
		testObj.setIsEP1Table(false);
		assertEquals("isEp1Table should be what you set it to",false,testObj.getIsEP1Table());
	}

	@Test
	public void testSetIsEP2Table() {
		testObj.setIsEP2Table(false);
		assertEquals("isEp2Table should be what you set it to",false,testObj.getIsEP2Table());
	}

}
