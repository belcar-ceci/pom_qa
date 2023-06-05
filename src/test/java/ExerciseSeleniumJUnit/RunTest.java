package ExerciseSeleniumJUnit;

import ExerciseSeleniumJUnit.InventorySuite.InventoryTest;
import ExerciseSeleniumJUnit.LoginSuite.UserLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserLogin.class,
        InventoryTest.class
})
public class RunTest {


}
