package Runner;

import java.io.IOException;

import org.junit.Test;

import cucumber.api.cli.Main;

@SuppressWarnings("deprecation")
public class JunitParallel {
	
	@Test
	public void test() throws IOException {
		String[] params = new String[] { "-p", "timeline:target/cucumber-parallel-report", "-g",
				"stepdefinitions", "src/test/java/Features/", "--threads", "6" };
		Main.run(params, Thread.currentThread().getContextClassLoader());
	}

}
