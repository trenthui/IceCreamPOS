import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * this is test suite of Junit 4
 */
@RunWith(Suite.class)
@SuiteClasses({
		Test1.class, //test1 class
		Test2.class //test2 class
	})
public class MyTestSuite {

}
