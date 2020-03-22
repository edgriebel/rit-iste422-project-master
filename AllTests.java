import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CreateDDLMySQLTest.class, 
	EdgeConnectorTest.class, 
	EdgeFieldTest.class, 
	EdgeTableTest.class })
public class AllTests {

}
