import static org.junit.Assert.*;
import java.io.*;
import org.junit.Before;
import org.junit.Test;

/*
 * March 4 2020
 * Initially created by: Brennan Jackson
 * Unit test class for EdgeConvertCreateDDL abstract class.
 * Test constructors, inialize, getField, and getTable methods implemented by the abstract class. 
 * Abstract methods are tested in implementation specific test classes
 * Concrete class used for testing is located at bottom of file
 * */

public class EdgeConvertCreateDDLTest {
	File edgeFile;
	EdgeConvertFileParser ecfp;
	ConcreteCreateDDL concreteNoArgs;
	ConcreteCreateDDL concreteWithArgs;
	EdgeTable[] tables;
	EdgeField[] fields;

	@Before
	public void setUp() throws Exception {
		edgeFile = new File("Courses.edg");//in order to test our concrete class constructor we need an edge file to parse
		ecfp = new EdgeConvertFileParser(edgeFile);
		tables = ecfp.getEdgeTables(); //get the edge tables
		fields = ecfp.getEdgeFields();//get the edge fields
		//create the related fields arrays for each edge table
		for (int i = 0; i < tables.length; i++) {
                  tables[i].makeArrays();
                }
		//create an instance with args and one without args
		concreteNoArgs = new ConcreteCreateDDL();
		concreteWithArgs = new ConcreteCreateDDL(tables,fields);
	}

	@Test
	public void testGetDatabaseName() {
		assertEquals("DatabaseName should be null",null,concreteNoArgs.getDatabaseName());
	}

	@Test
	public void testGetProductName() {
		assertEquals("ProductName should be null",null,concreteNoArgs.getProductName());
	}

	@Test
        public void testGetSQLString() {
                assertEquals("SQLString should be null",null,concreteNoArgs.getSQLString());
        }

	@Test
	public void testNumBoundTables() {
		int boundTables = concreteWithArgs.numBoundTables.length;
		assertEquals("Number of Bound Tables is 3",3,boundTables);
	}

	@Test
	public void testStringBufferInitialized() {
		boolean sbIsSet = (concreteWithArgs.sb != null);
		assertEquals("StringBuffer is initialized",true,sbIsSet);
	}

	@Test
	public void testDefaultProducts() {
		String defaultProduct = concreteNoArgs.products[0];
		assertEquals("Default product is 'MySQL'","MySQL",defaultProduct);
	}

	@Test
	public void testGetTableStudent() {
		String tableName = concreteWithArgs.getTable(1).getName();
		assertEquals("First table is student","STUDENT",tableName);//tables are retrieved by using their numFigure not index.
	}

	@Test
        public void testGetTableFaculty() {
                String tableName = concreteWithArgs.getTable(2).getName();
                assertEquals("Second table is faculty","FACULTY",tableName);
        }

	@Test
        public void testGetTableCourses() {
                String tableName = concreteWithArgs.getTable(13).getName();
                assertEquals("Third table is courses","COURSES",tableName);
        }

	@Test
        public void testGetTableNull() {
                EdgeTable table = concreteWithArgs.getTable(0);
                assertEquals("Table with nimFigure 0 is null",null,table);
        }

	@Test
	public void testGetFieldGrade() {
		String fieldName = concreteWithArgs.getField(3).getName();//fields are retrieved using their numFigure
		assertEquals("First Field is 'Grade'","Grade",fieldName);
	}

	@Test
        public void testGetFieldCourseName() {
                String fieldName = concreteWithArgs.getField(4).getName();//fields are retrieved using their numFigure
                assertEquals("Second Field is 'CourseName'","CourseName",fieldName);
        }

	@Test
        public void testGetFieldNumber() {
                String fieldName = concreteWithArgs.getField(5).getName();//fields are retrieved using their numFigure
                assertEquals("Third Field is 'Number'","Number",fieldName);
        }

	@Test
        public void testGetFieldFacSSN() {
                String fieldName = concreteWithArgs.getField(6).getName();
                assertEquals("Fourth Field is 'FacSSN'","FacSSN",fieldName);
        }

	@Test
        public void testGetFieldStudentSSN() {
                String fieldName = concreteWithArgs.getField(7).getName();//fields are retrieved using their numFigure
                assertEquals("Fifth Field is 'StudentSSN'","StudentSSN",fieldName);
        }

	@Test
        public void testGetFieldStudentName() {
                String fieldName = concreteWithArgs.getField(8).getName();//fields are retrieved using their numFigure
                assertEquals("Sixth Field is 'StudentName'","StudentName",fieldName);
        }

	@Test
        public void testGetFieldFacultyName() {
                String fieldName = concreteWithArgs.getField(11).getName();//fields are retrieved using their numFigure
                assertEquals("Seventh Field is 'FacultyName'","FacultyName",fieldName);
        }

	@Test
        public void testGetFieldNull() {
                EdgeField field = concreteWithArgs.getField(0);
                assertEquals("NumFigure 0 Field is null",null,field);
        }

} //end EdgeConvertCreateDDLTest


/*Concrete class for testing abstract EdgeConvertCreateDDL class*/

class ConcreteCreateDDL extends EdgeConvertCreateDDL {

	public ConcreteCreateDDL(EdgeTable[] inputTables, EdgeField[] inputFields) {
		super(inputTables, inputFields);
	}

	//default constructor with no args
        public ConcreteCreateDDL() {}

	//implement abstract classes to return null
	public String getDatabaseName(){
		return null;
	}

	public String getProductName() {
		return null;
	}

	public String getSQLString() {
		return null;
	}

	public void createDDL(){/*Do nothing*/}

} // end ConcreteCreateDDL
