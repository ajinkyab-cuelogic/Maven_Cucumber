package stepdefinitions;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook {
	
	
	private TestContext context;
	
	public Hook(TestContext context) {
		this.context = context;
	}


	
	@Before
    public void initialiseDriver() {	
		context.enterURL();
		
	}
	
	
	@After
	public void cleanUp() {
		context.getDriverManager().closeDriver();;
	}
	

	
}
