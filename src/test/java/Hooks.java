import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.Driver;

public class Hooks {
    private Driver driverManager = new Driver();
    @Before
    public void setUp(){
        driverManager.openBrowser();
    }
    @After
    public void tearDown(){
        driverManager.closeBrowser();
    }

}
