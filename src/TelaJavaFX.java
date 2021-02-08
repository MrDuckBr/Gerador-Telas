import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;




//extend => HERANCA  -> descendencia de um individuo/ancestral
public class TelaJavaFX extends Application{


	Stage primaryStage;
	Scene cenaPrincipal;
	JsonHash jsonH;
//	GridPaneCreator gridPane1 = new GridPaneCreator();


	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		jsonH = new JsonHash(this); // adicionei as cenas criadas aqui no hash map
//		primaryStage.setScene(jsonH.teste());
//		primaryStage.setScene(gridPane1.construtor());
//COmentei aqui porque tem que definir a primeira cena.

		//FULL SCREEN

		//botao gradiente
		//primaryStage.setFullScreen(true);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}



	
	//funcoes para o hash map sendo feitas a partir daqui
	public void mudarCena(Scene tela , String nome) {
		primaryStage.setScene(tela);
		primaryStage.setTitle(nome);
		primaryStage.setFullScreen(true);
	}
}