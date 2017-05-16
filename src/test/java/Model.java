import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Vertex;

public class Model {

	public Model createModel() {

		// Create a new, empty model
		Model model = new Model();

		// Create vertexes (nodes)
		Vertex v_Start = new Vertex().setName("v_Start");
		Vertex v_HomePage = new Vertex().setName("v_HomePage");
		Vertex v_ErrorPage = new Vertex().setName("v_ErrorPage");
		Vertex v_AccountsOverviewPage = new Vertex().setName("v_AccountsOverviewPage");

		// Create edges
		Edge e_StartBrowser = new Edge().setName("e_StartBrowser").setSourceVertex(v_Start).setTargetVertex(v_HomePage);
		Edge e_LoginFailed = new Edge().setName("e_LoginFailed").setSourceVertex(v_HomePage)
				.setTargetVertex(v_ErrorPage);
		Edge e_LoginFailedAgain = new Edge().setName("e_LoginFailedAgain").setSourceVertex(v_ErrorPage)
				.setTargetVertex(v_ErrorPage);
		Edge e_LoginSucceeded = new Edge().setName("e_LoginSucceeded").setSourceVertex(v_HomePage)
				.setTargetVertex(v_AccountsOverviewPage);
		Edge e_LoginSucceededAfterFailure = new Edge().setName("e_LoginSucceededAfterFailure")
				.setSourceVertex(v_ErrorPage).setTargetVertex(v_AccountsOverviewPage);
		Edge e_Logout = new Edge().setName("e_Logout").setSourceVertex(v_AccountsOverviewPage)
				.setTargetVertex(v_HomePage);

		// Add vertexes to the model
		model.addVertex(v_Start);
		model.addVertex(v_HomePage);
		model.addVertex(v_ErrorPage);
		model.addVertex(v_AccountsOverviewPage);

		// Add edges to the model
		model.addEdge(e_StartBrowser);
		model.addEdge(e_LoginFailed);
		model.addEdge(e_LoginFailedAgain);
		model.addEdge(e_LoginSucceeded);
		model.addEdge(e_LoginSucceededAfterFailure);
		model.addEdge(e_Logout);

		return model;
	}

}
