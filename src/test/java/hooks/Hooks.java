package hooks;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void BeforeSteps(){

    }

    @After
    public void AfterSteps(){
        testContext.getWebDriverManager().closeDriver();
    }

}
