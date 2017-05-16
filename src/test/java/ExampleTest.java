import java.util.concurrent.TimeUnit;

import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.machine.SimpleMachine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {

	WebDriver driver = null;

	public void e_StartBrowser() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://parabank.parasoft.com");
	}

	public void v_HomePage() {

		Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
	}

	@Test
	public void fullCoverageTest() {

		// Create an instance of our model
		Model model = createModel();

		// Build the model (make it immutable) and give it to the execution
		// context
		this.setModel(model.build());

		// Tell GraphWalker to run the model in a random fashion,
		// until every vertex is visited at least once.
		// This is called the stop condition.
		this.setPathGenerator(new RandomPath(new VertexCoverage(100)));

		// Get the starting vertex (v_Start)
		setNextElement(model.getVertices().get(0));

		// Create the machine that will control the execution
		Machine machine = new SimpleMachine(this);

		// As long as the stop condition of the path generator is not fulfilled,
		// hasNext will return true.
		while (machine.hasNextStep()) {

			// Execute the next step of the model.
			machine.getNextStep();
		}
	}

}
